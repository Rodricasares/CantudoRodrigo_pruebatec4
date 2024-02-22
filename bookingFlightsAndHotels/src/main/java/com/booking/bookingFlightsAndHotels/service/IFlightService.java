package com.booking.bookingFlightsAndHotels.service;

import com.booking.bookingFlightsAndHotels.model.Flight;

import java.time.LocalDate;
import java.util.List;

public interface IFlightService {
    public List<Flight> getFlights();

    public void saveFlight(Flight flight);

    public void deleteFlight(Long id);

    public Flight findFlight(Long id);

    public List<Flight> findAvailableFlights(LocalDate date, Boolean bookingStatus, String origin, String destination );

    public List<Flight> arrivals(String destination, boolean isBooked);

    public List<Flight> departures(String origin, boolean isBooked);

   public List<Flight> lookingForFlight(String origin, String destination, Boolean isBooked);
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

}
