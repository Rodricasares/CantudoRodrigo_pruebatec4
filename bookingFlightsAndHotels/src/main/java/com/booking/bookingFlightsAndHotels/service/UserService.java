package com.booking.bookingFlightsAndHotels.service;

import com.booking.bookingFlightsAndHotels.model.User;
import com.booking.bookingFlightsAndHotels.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public List<User> getUsers() {

        return userRepo.findAll();

    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public User findUser(Long id) {

        return userRepo.findById(id).orElse(null);

    }

    @Override
    public List<User> findByName(String name, Integer age) {
        return userRepo.findByName(name, age);
    }
}

