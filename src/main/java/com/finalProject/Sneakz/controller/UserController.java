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
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> createUser (@RequestBody User user){
        return new ResponseEntity<>(userService.create(user), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById (@PathVariable(value="id") long id){
        User user = userService.findByUserId(id).orElseThrow();
        return new ResponseEntity<>(user,HttpStatus.FOUND);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUser (){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.FOUND);
    }
}
