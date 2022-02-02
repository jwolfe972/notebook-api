package com.jordanbook.notebook.repos;

import com.jordanbook.notebook.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo  extends JpaRepository<User, Long> {

    Optional<User> findUserByuserID(Long id);


    Optional<User> findUserByuserName(String id);


}
