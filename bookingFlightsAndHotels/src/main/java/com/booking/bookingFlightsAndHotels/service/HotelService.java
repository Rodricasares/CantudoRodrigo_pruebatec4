package com.booking.bookingFlightsAndHotels.service;

import com.booking.bookingFlightsAndHotels.model.Hotel;

import com.booking.bookingFlightsAndHotels.model.Room;
import com.booking.bookingFlightsAndHotels.repository.HotelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class HotelService implements IHotelService{
    @Autowired
    private HotelRepository hotelRepo;

    @Override
    public List<Hotel> getHotels() {

        return hotelRepo.findAll();

    }

    @Override
    public void saveHotel(Hotel hotel) {
        hotelRepo.save(hotel);
    }

    @Override
    public void deleteHotel(Long id) {
        hotelRepo.deleteById(id);
    }

    @Override
    public Hotel findHotel(Long id) {

        return hotelRepo.findById(id).orElse(null);

    }


}
