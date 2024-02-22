package com.booking.bookingFlightsAndHotels.service;

import com.booking.bookingFlightsAndHotels.model.User;

import java.util.List;

public interface IUserService {

   public List<User> getUsers();

  public  void saveUser(User user);

   public void deleteUser(Long id);

    public User findUser(Long id);


  public  List<User> findByName(String name, Integer age);
}
