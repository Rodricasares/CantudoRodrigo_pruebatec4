package com.booking.bookingFlightsAndHotels.controller;


import com.booking.bookingFlightsAndHotels.model.Flight;
import com.booking.bookingFlightsAndHotels.model.User;
import com.booking.bookingFlightsAndHotels.service.IFlightService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private IFlightService bookedFlightServ;

    @PostMapping("/reserve/{id}")
    public Flight reserveFlight(@PathVariable Long id,
                                @RequestParam("user") User userModif,
                                //@RequestParam("hotel") Hotel hotelModif,
                                @RequestParam("isBooked") Boolean bookedModif) {

        Flight flight = bookedFlightServ.findFlight(id);


        flight.setUser(userModif);
        // flight.getFlight();
        flight.setIsBooked(bookedModif);

        bookedFlightServ.saveFlight(flight);

        return flight;

    }

    @GetMapping("/{id}")
    public Flight getFlightId(@PathVariable Long id) {
        return bookedFlightServ.findFlight(id);
    }

    @GetMapping("/getAll")
    public List<Flight> getFlight() {
        return bookedFlightServ.getFlights();
    }

    @PostMapping("/add")
    public String saveFlight(@RequestBody Flight flight) {

        bookedFlightServ.saveFlight(flight);
        return "Successfully created flight";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFlight(@PathVariable Long id) {
        bookedFlightServ.deleteFlight(id);
        return "Flight successfully removed";
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
    public Flight editFlight(@PathVariable Long id,
                           @RequestParam("flightNumber") String flightNumberModif,
                           @RequestParam("name") String nameModif,
                           @RequestParam("origin") String originModif,
                           @RequestParam("destination") String destinationInModif,
                           @RequestParam("isBooked") Boolean isBookedModif,
                           @RequestParam("seatType") String seatTypeModif,
                           @RequestParam("flightPrice") Double flightPriceModif,
                           @RequestParam("use") User userModif) {

        Flight flight = bookedFlightServ.findFlight(id);

        flight.setFlightNumber(flightNumberModif);
        flight.setName(nameModif);
        flight.setOrigin(originModif);
        flight.setDestination(destinationInModif);
        flight.setIsBooked(isBookedModif);
        flight.setSeatType(seatTypeModif);
        flight.setFlightPrice(flightPriceModif);
        flight.setUser(userModif);

        bookedFlightServ.saveFlight(flight);

        return flight;

    }

    @GetMapping("/available")
    public ResponseEntity<List<Flight>> getAvailableFlights(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam("origin") String origin,
            @RequestParam("destination") String destination,
            @RequestParam("isBooked") Boolean bookingStatus) {

        List<Flight> availableFlights = bookedFlightServ.findAvailableFlights(date, bookingStatus, origin, destination);

        if (availableFlights.isEmpty()) {
            // No hay vuelos disponibles, puedes devolver una respuesta personalizada
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        } else {
            // Hay vuelos disponibles, devolver la lista normalmente
            return ResponseEntity.ok(availableFlights);
        }
    }



    @GetMapping("/arrivals/{destination}/{isBooked}")
    public List<Flight>getFlightArrivalsRepository(@PathVariable String destination, @PathVariable Boolean isBooked){
        return bookedFlightServ.arrivals(destination,isBooked);
    }
    @GetMapping("/departures/{origin}/{isBooked}")
    public List<Flight>getFlightDeparturesRepository(@PathVariable String origin, @PathVariable Boolean isBooked){
        return bookedFlightServ.departures(origin,isBooked);
    }

    @GetMapping("/find/{origin}/{destination}/{isBooked}")
    public List<Flight>lookingForFlight(@PathVariable String origin, @PathVariable String destination,  @PathVariable Boolean  isBooked){
        return bookedFlightServ.lookingForFlight(origin,destination, isBooked);
    }
}
