package com.booking.bookingFlightsAndHotels.service;
import com.booking.bookingFlightsAndHotels.model.Flight;
import com.booking.bookingFlightsAndHotels.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService implements IFlightService {
    @Autowired
    private FlightRepository bookFlightRepo;

    @Override
    public List<Flight> getFlights() {

        return bookFlightRepo.findAll();

    }

    @Override
    public void saveFlight(Flight flight) {
        bookFlightRepo.save(flight);
    }

    @Override
    public void deleteFlight(Long id) {
        bookFlightRepo.deleteById(id);
    }

    @Override
    public Flight findFlight(Long id) {

        return bookFlightRepo.findById(id).orElse(null);

    }
/*
    @Autowired
    private ModelMapper modelMapper;

    private RoomDto getRoomDto(Room room){
        return modelMapper.map(room, RoomDto.class);
    }


    @Override
    public List<RoomDto> listRoomsDto(){
        List<Room> rooms= bookHotelRepo.findAll();
        if (rooms.isEmpty()){
            throw new RuntimeException("No Hotels found.");
        }return rooms.stream()
                .map(this::getRoomDto)
                .collect(Collectors.toList());
    }
*/
    @Override
    public  List<Flight> findAvailableFlights(LocalDate date, Boolean bookingStatus, String origin,String destination ) {
        // Aquí debes implementar la lógica para buscar las habitaciones disponibles
        // durante el rango de fechas especificado
        // Puedes utilizar un método de repositorio u otro mecanismo de almacenamiento

        // Este es solo un ejemplo básico, deberías adaptarlo según tu aplicación
        List<Flight> allFlights = bookFlightRepo.findAll(); // Supongamos que hay un método getAllRooms en tu repositorio
        List<Flight> availableFlights = new ArrayList<>();


        for (Flight flight : allFlights) {
            if (!flight.getIsBooked() && isFlightAvailableForDates(flight, date, origin, destination)){
                availableFlights.add(flight);

            }
        }

        return availableFlights  ;
    }

    // Método auxiliar para verificar la disponibilidad de la habitación para un rango de fechas
    private boolean isFlightAvailableForDates(Flight flight, LocalDate date, String origin, String destination) {
        LocalDate flightDate = flight.getDate();
        String flightOrigin = flight.getOrigin();
        String flightDestination = flight.getDestination();


        // Verificar si la fecha y el destino coinciden
        return !flight.getIsBooked() && date.isEqual(flightDate) && origin.equalsIgnoreCase(flightOrigin) && destination.equalsIgnoreCase(flightDestination) ;
    }


    @Override
    public List<Flight> arrivals(String destination, boolean isBooked) {
        return bookFlightRepo.findByArrivals(destination, isBooked);
    }

    @Override
    public List<Flight> departures(String origin, boolean isBooked) {
        return bookFlightRepo.findByDepartures(origin, isBooked);
    }

    @Override
    public List<Flight> lookingForFlight(String origin, String destination, Boolean isBooked) {
        return bookFlightRepo.findByOriginAndDestination(origin, destination, isBooked);
    }
}
