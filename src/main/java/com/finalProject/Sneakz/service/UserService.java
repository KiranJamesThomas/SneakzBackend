package com.finalProject.Sneakz.service;

import com.finalProject.Sneakz.entity.Product;
import com.finalProject.Sneakz.entity.User;
import com.finalProject.Sneakz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){ return userRepository.findAll();}

    public User create(User user){
        return userRepository.save(user);
    }

    public Optional<User> findByUserId(long id){
        return userRepository.findById(id);
    }
}
