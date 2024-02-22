package com.booking.bookingFlightsAndHotels.service;

import com.booking.bookingFlightsAndHotels.model.Hotel;
import com.booking.bookingFlightsAndHotels.model.Room;

import java.time.LocalDate;
import java.util.List;

public interface IHotelService {
    public List<Hotel> getHotels();
    public void saveHotel(Hotel hotel);
    public  void deleteHotel(Long id);
    public Hotel findHotel (Long id);

}
