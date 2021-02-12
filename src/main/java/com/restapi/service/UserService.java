package com.restapi.service;

import com.restapi.model.User;
import com.restapi.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UsersRepo usersRepo;

    public ResponseEntity save(User user){

        Optional<User> userByEmail = usersRepo.findUserByEmail(user.getEmailAddress());

        if(user.emailContains() && !userByEmail.isPresent()) {
            usersRepo.save(user);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .body("Duplicate of email or email doesnt include '@' ");
    }

    public List<User> getAllUsers(){
        return usersRepo.findAll();
    }

    public ResponseEntity userById(Long userId){
        Optional<User> user = usersRepo.findById(userId);

        if(user.isPresent()){
            return ResponseEntity
                    .ok(user.get());
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("User with: " + userId + " was not found");

    }

    public ResponseEntity deleteUser(Long userId){
        boolean exists = usersRepo.existsById(userId);

        if(!exists){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("User with: " + userId + " id was not found");
        }
        usersRepo.deleteById(userId);
        return ResponseEntity.ok().build();
    }

}
