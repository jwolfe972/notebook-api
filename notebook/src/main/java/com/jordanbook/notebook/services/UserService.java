package com.jordanbook.notebook.services;


import com.jordanbook.notebook.models.User;
import com.jordanbook.notebook.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UnknownFormatConversionException;

@Service
public class UserService {


    private final UserRepo userRepo;
    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public User AddUser(User u){

        return
        userRepo.save(u);



    }


    public User UpdateUser(User u){


        return userRepo.save(u);
    }

    public List<User> ListAllUsers(){


        return userRepo.findAll();
    }

    public User findUserByID(Long id){


        return userRepo.findUserByuserID(id).orElseThrow(

                () -> new UnknownFormatConversionException("UserID not foudn")
        );
    }

    public User findUserByuserName(String  name){



        return userRepo.findUserByuserName(name).orElseThrow(

                () -> new UnknownFormatConversionException("UserID not foudn")
        );
    }


    public void DeleteUser(Long id){



        userRepo.deleteById(id);
    }
}
