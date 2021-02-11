package com.restapi.controller;

import com.restapi.model.User;
import com.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class UsersController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(path ="/users/{userId}")
    public ResponseEntity<User> userById(@PathVariable("userId") Long userId){
       return userService.userById(userId);
    }

    @DeleteMapping(path = "/users/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable("userId") Long userId){
       return userService.deleteUser(userId);
    }

}
