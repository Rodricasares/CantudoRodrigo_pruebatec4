package com.booking.bookingFlightsAndHotels.repository;

import com.booking.bookingFlightsAndHotels.model.Flight;
import com.booking.bookingFlightsAndHotels.model.Room;
import com.booking.bookingFlightsAndHotels.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface FlightRepository extends JpaRepository<Flight,Long> {


    @Query("SELECT u FROM Flight u WHERE u.destination = :destination AND u.isBooked = :isBooked")
    public List<Flight> findByArrivals(String destination, boolean isBooked);

    @Query("SELECT u FROM Flight u WHERE u.origin = :origin AND u.isBooked = :isBooked")
    public List<Flight> findByDepartures(String origin, boolean isBooked);

    @Query("SELECT u FROM Flight u WHERE u.origin = :origin AND u.destination = :destination AND u.isBooked = :isBooked")
    public List<Flight> findByOriginAndDestination(String origin, String destination, boolean isBooked);

}
