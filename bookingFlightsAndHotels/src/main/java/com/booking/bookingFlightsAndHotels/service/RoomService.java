package com.booking.bookingFlightsAndHotels.service;


import com.booking.bookingFlightsAndHotels.dto.RoomDto;
import com.booking.bookingFlightsAndHotels.model.Hotel;
import com.booking.bookingFlightsAndHotels.model.Room;
import com.booking.bookingFlightsAndHotels.repository.RoomRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoomService implements IRoom {
    @Autowired
    private RoomRepository bookHotelRepo;

    @Override
    public List<Room> getRooms() {

        return bookHotelRepo.findAll();

    }

    @Override
    public void saveRoom(Room room) {
        bookHotelRepo.save(room);
    }

    @Override
    public void deleteRoom(Long id) {
        bookHotelRepo.deleteById(id);
    }

    @Override
    public Room findRoom(Long id) {

        return bookHotelRepo.findById(id).orElse(null);

    }

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

    @Override
    public  List<Room> findAvailableRooms( LocalDate checkIn, LocalDate checkOut, Boolean bookingStatus) {

        List<Room> allRooms = bookHotelRepo.findAll();
        List<Room> availableRooms = new ArrayList<>();

        for (Room room : allRooms) {
            if (!room.getBooked() && isRoomAvailableForDates(room, checkIn, checkOut)) {
                availableRooms.add(room);
            }
        }

        return availableRooms;
    }
    private boolean isRoomAvailableForDates( Room room, LocalDate checkIn, LocalDate checkOut) {

        LocalDate roomCheckIn = room.getCheckIn();
        LocalDate roomCheckOut = room.getCheckOut();

        return !(checkOut.isBefore(roomCheckIn) || checkIn.isAfter(roomCheckOut) );
    }

}


