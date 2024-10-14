package com.finalProject.Sneakz.controller;

import com.finalProject.Sneakz.entity.User;
import com.finalProject.Sneakz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Sneakz")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> createUser (@RequestBody User user){
        String email = user.getEmail();
        String password = user.getPassword();
        return new ResponseEntity<>(userService.registerUser(email, password), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User authenticatedUser = userService.loginUser(user.getEmail(), user.getPassword());
        if (authenticatedUser != null) {
            return ResponseEntity.ok(authenticatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById (@PathVariable(value="id") long id){
        User user = userService.findByUserId(id).orElseThrow();
        return new ResponseEntity<>(user,HttpStatus.FOUND);
    }

    @GetMapping("/user/email/{email}")
    public ResponseEntity<User> getUserByEmail (@PathVariable(value="email") String email){
        User user = userService.findByEmail(email).orElseThrow();
        return new ResponseEntity<>(user,HttpStatus.FOUND);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUser (){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.FOUND);
    }
}
