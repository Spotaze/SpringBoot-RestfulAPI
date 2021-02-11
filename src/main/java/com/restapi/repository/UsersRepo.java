package com.restapi.repository;

import com.restapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.emailAddress = ?1")
    Optional<User> findUserByEmail(String emailAddress);
}
