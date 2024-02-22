package com.booking.bookingFlightsAndHotels.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {

    private Long id;
    private int type;
    private int roomNumber;
    private Double price;
    private Boolean booked;

}
