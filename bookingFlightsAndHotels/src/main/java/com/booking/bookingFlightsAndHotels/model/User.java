package com.booking.bookingFlightsAndHotels.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Data
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String last_name;
    private int age;

   // @JsonIgnore
   // @JsonManagedReference
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Room> rooms;

    //@JsonIgnore
  //  @JsonManagedReference
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Flight> flights;


}

