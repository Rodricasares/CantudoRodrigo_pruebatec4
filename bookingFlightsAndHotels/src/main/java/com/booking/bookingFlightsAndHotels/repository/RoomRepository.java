package com.booking.bookingFlightsAndHotels.repository;

import com.booking.bookingFlightsAndHotels.model.Hotel;
import com.booking.bookingFlightsAndHotels.model.Room;
import com.booking.bookingFlightsAndHotels.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {

/*
    @Query("SELECT r FROM Room r WHERE r.checkIn <= :checkOut AND r.checkOut >= :checkIn AND r.booking = :bookingStatus")
    List<Room> findAvailableRooms(@Param("checkIn") LocalDate checkIn, @Param("checkOut") LocalDate checkOut, @Param("bookingStatus") Boolean bookingStatus);
*/

}
