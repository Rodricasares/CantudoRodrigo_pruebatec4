

package com.booking.bookingFlightsAndHotels.controller;

import com.booking.bookingFlightsAndHotels.dto.RoomDto;
import com.booking.bookingFlightsAndHotels.model.Hotel;
import com.booking.bookingFlightsAndHotels.model.Room;
import com.booking.bookingFlightsAndHotels.model.User;
import com.booking.bookingFlightsAndHotels.service.IRoom;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private IRoom bookedRoomServ;

    @PostMapping("/addRoom/{id}")
    public ResponseEntity<String> signRoomToHotel(
            @PathVariable Long id,
            @RequestParam("hotel") Hotel hotelModif,
            @RequestParam("booked") Boolean bookedModif) {

        // Verificar si la habitación con el Id existe
        Room room = bookedRoomServ.findRoom(id);
        if (room == null) {
            return ResponseEntity.notFound().build();
        }

        // Actualizar la habitación con los valores proporcionados
        room.setHotel(hotelModif);
        room.setBooked(bookedModif);

        // Guardar la habitación
        bookedRoomServ.saveRoom(room);

        // Devolver la habitación actualizada
        return ResponseEntity.ok("La habitación se asignó satisfactoriamente al hotel.");
    }

    @PostMapping("/reserve/{id}")
    public Room reserveRoom(@PathVariable Long id,
                            @RequestParam("user") User userModif,
                            @RequestParam("booked") Boolean bookedModif) {

        Room room = bookedRoomServ.findRoom(id);

        room.setUser(userModif);
        room.getHotel();
        room.setBooked(bookedModif);

        bookedRoomServ.saveRoom(room);

        return room;

    }

    @GetMapping("/{id}")
    public Room getRoomId(@PathVariable Long id) {
        return bookedRoomServ.findRoom(id);
    }

    @GetMapping("/getAll")
    public List<Room> getRooms() {
        return bookedRoomServ.getRooms();
    }

    @PostMapping("/add")
    public String saveRoom(@RequestBody Room room) {

        bookedRoomServ.saveRoom(room);
        return "Successfully created room";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRoom(@PathVariable Long id) {
        bookedRoomServ.deleteRoom(id);
        return "Room successfully removed";
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La operación se ejecutó correctamente"),
            @ApiResponse(responseCode = "201", description = "Recurso creado exitosamente"),
            @ApiResponse(responseCode = "204", description = "La operación se ejecutó correctamente pero no hay contenido para devolver"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "401", description = "No autorizado"),
            @ApiResponse(responseCode = "403", description = "Prohibido, no tiene los permisos necesarios"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PutMapping("/edit/{id}")
    public Room editRoom(@PathVariable Long id,
                         @RequestParam("type") int typeModif,
                         @RequestParam("roomNumber") int roomNumModif,
                         @RequestParam("price") Double priceModif,
                         @RequestParam("checkIn") LocalDate checkInModif,
                         @RequestParam("checkOut") LocalDate checkOutModif,
                         @RequestParam("user") User userModif,
                         @RequestParam("booked") Boolean bookedModif,
                         @RequestParam("hotel") Hotel hotelModif) {

        Room room = bookedRoomServ.findRoom(id);

        room.setType(typeModif);
        room.setPrice(priceModif);
        room.setRoomNumber(roomNumModif);
        room.setCheckIn(checkInModif);
        room.setCheckOut(checkOutModif);
        room.setUser(userModif);
        room.setHotel(hotelModif);
        room.setBooked(bookedModif);

        bookedRoomServ.saveRoom(room);

        return room;

    }

    @GetMapping("/roomsDto")
    public List<RoomDto> getRoomsDto() {
        return bookedRoomServ.listRoomsDto();
    }

    @GetMapping("/available")
    public ResponseEntity<List<Room>> getAvailableRooms(
            @RequestParam("checkIn") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn,
            @RequestParam("checkOut") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut,
            @RequestParam("booked") Boolean bookingStatus) {

        List<Room> availableRooms = bookedRoomServ.findAvailableRooms(checkIn, checkOut, bookingStatus);

        return ResponseEntity.ok(availableRooms);
    }

    @PostMapping("/reserveByDate")
    public ResponseEntity<String> reserveRoomByDate(
            @RequestParam("roomId") Long roomId,
            @RequestParam("checkIn") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn,
            @RequestParam("checkOut") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut,
            @RequestParam("user") User userModif) {

        try {
            // Verificar la disponibilidad de la habitación para las fechas seleccionadas
            List<Room> availableRooms = bookedRoomServ.findAvailableRooms(checkIn, checkOut, false);

            // Buscar la habitación específica por ID
            Room room = bookedRoomServ.findRoom(roomId);

            // Verificar si la habitación está disponible
            if (availableRooms.contains(room)) {
                // Reservar la habitación para el usuario
                // User user = new User(); // Aquí deberías obtener el usuario por su ID
                room.setUser(userModif);
                room.setCheckIn(checkIn);
                room.setCheckOut(checkOut);
                room.setBooked(true);

                bookedRoomServ.saveRoom(room);

                return ResponseEntity.ok("Room reserved successfully");
            } else {

                return ResponseEntity.badRequest().body("Room is not available for the selected dates");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error reserving room: " + e.getMessage());
        }
    }
}



