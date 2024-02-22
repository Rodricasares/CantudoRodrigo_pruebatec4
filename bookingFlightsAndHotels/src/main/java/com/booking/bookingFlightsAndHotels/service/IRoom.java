package com.booking.bookingFlightsAndHotels.service;

import com.booking.bookingFlightsAndHotels.dto.HotelDto;
import com.booking.bookingFlightsAndHotels.dto.RoomDto;
import com.booking.bookingFlightsAndHotels.model.Hotel;
import com.booking.bookingFlightsAndHotels.model.Room;

import java.time.LocalDate;
import java.util.List;

public interface IRoom {
    public List<Room> getRooms();

    public void saveRoom(Room room);

    public void deleteRoom(Long id);

    public Room findRoom(Long id);

    public List<RoomDto> listRoomsDto();

    public List<Room> findAvailableRooms(LocalDate checkIn, LocalDate checkOut, Boolean bookingStatus);


}
