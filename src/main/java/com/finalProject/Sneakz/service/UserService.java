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

    public Optional<User> findByEmail(String email){
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

    public Optional<User> findByUserId(long id){
        return userRepository.findById(id);
    }

    public User registerUser(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        return userRepository.save(user);
    }

    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && password.equals(user.getPassword())) {
            return user; // Successful login
        }
        return null; // Login failed
    }
}
