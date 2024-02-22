package com.booking.bookingFlightsAndHotels.repository;

import com.booking.bookingFlightsAndHotels.model.Hotel;
import com.booking.bookingFlightsAndHotels.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
