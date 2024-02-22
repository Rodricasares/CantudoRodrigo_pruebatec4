package com.booking.bookingFlightsAndHotels.controller;

import com.booking.bookingFlightsAndHotels.model.Flight;
import com.booking.bookingFlightsAndHotels.model.Hotel;
import com.booking.bookingFlightsAndHotels.service.IHotelService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private IHotelService hotelServ;
    @GetMapping("/{id}")
    public Hotel getHotelId(@PathVariable Long id){
     return hotelServ.findHotel(id);
    }
    @GetMapping("/getAll")
    public List<Hotel> getHotels() {
        return hotelServ.getHotels();
    }

    @PostMapping("/add")
    public String saveHotel(@RequestBody Hotel user) {
        hotelServ.saveHotel(user);
        return "Successfully created hotel";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteHotel (@PathVariable Long id) {
        hotelServ.deleteHotel(id);
        return "Hotel successfully removed";
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
    @PutMapping ("/edit/{id}")
    public Hotel editHotel (@PathVariable Long id,
                             @RequestParam ("name") String nameModif,
                             @RequestParam ("city") String cityModif,
                             @RequestParam ("code") String codeModif) {

        Hotel hotel = hotelServ.findHotel(id);

        hotel.setName(nameModif);
        hotel.setCity(cityModif);
        hotel.setCode(codeModif);

        hotelServ.saveHotel(hotel);

        return hotel;

    }


}
