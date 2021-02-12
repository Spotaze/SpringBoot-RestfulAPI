package com.restapi.controller;

import com.restapi.model.User;
import com.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity createUser(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(path ="/{userId}")
    public ResponseEntity userById(@PathVariable("userId") Long userId){
       return userService.userById(userId);
    }

    @DeleteMapping(path = "/delete/{userId}")
    public ResponseEntity deleteUser(@PathVariable("userId") Long userId){
       return userService.deleteUser(userId);
    }

}
