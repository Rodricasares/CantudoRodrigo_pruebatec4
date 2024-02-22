package com.booking.bookingFlightsAndHotels.repository;

import com.booking.bookingFlightsAndHotels.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
 @Query("SELECT u FROM User u WHERE u.name = :name AND u.age = :age")
   public List<User> findByName(String name, Integer age);

/*
    @Query("SELECT p FROM Paciente p where p.nombre =?1")
    List<Paciente> buscarPorNombre(String nombre);*/
}
