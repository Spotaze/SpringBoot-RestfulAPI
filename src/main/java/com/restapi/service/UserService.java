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

    public ResponseEntity<User> save(User user){

        Optional<User> userByEmail = usersRepo.findUserByEmail(user.getEmailAddress());

        if(user.emailContains() && !userByEmail.isPresent()) {
            usersRepo.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }

    public List<User> getAllUsers(){
        return usersRepo.findAll();
    }

    public ResponseEntity<User> userById(Long userId){
        Optional<User> user = usersRepo.findById(userId);

        if(user.isPresent()){
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    public ResponseEntity<User> deleteUser(Long userId){
        boolean exists = usersRepo.existsById(userId);

        if(!exists){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        usersRepo.deleteById(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
