package com.restapi.service;

import com.restapi.exception.CustomException;
import com.restapi.model.User;
import com.restapi.repository.UsersRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UsersRepo usersRepo;

    public UserService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    public void save(User user){

        Optional<User> userByEmail = usersRepo.findUserByEmail(user.getEmailAddress());

        if(!user.emailContains()){
            throw new CustomException("Email doesnt contain '@'");
        }

        if(userByEmail.isPresent()){
            throw new CustomException("Email is already taken");
        }

        usersRepo.save(user);
    }

    public List<User> getAllUsers(){
        return usersRepo.findAll();
    }

    public User userById(Long userId){
        Optional<User> user = usersRepo.findById(userId);

        if(user.isPresent()){
            return user.get();
        }else{
            throw new CustomException("User with id: " + userId + " was not found");
        }

    }

    public void deleteUser(Long userId){
        boolean exists = usersRepo.existsById(userId);

        if(!exists){
            throw new CustomException("User doesnt exist with this id: " + userId);
        }
        usersRepo.deleteById(userId);
    }

}
