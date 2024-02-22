package com.booking.bookingFlightsAndHotels.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Data
@Builder
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flightNumber;
    private String name;
    private String origin;
    private String destination;
    private Boolean isBooked;
    private String seatType;
    private Double flightPrice;


    private LocalDate date;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
