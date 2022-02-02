package com.jordanbook.notebook.resources;


import com.jordanbook.notebook.models.User;
import com.jordanbook.notebook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }



    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){


        List<User> userList = userService.ListAllUsers();


        return new ResponseEntity<>(userList, HttpStatus.OK);
    }


    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable("username") String name){



    User u = userService.findUserByuserName(name);


    return new ResponseEntity<>(u, HttpStatus.OK);




    }


    @PostMapping("/signup")
    public ResponseEntity<User> addUser(@RequestBody User u){


        u.setAccountCreationDate(new Date());
        u.setAccountActivated(false);
        u.setAccountLocked(false);


        User user = userService.AddUser(u);

        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }


    @PutMapping("/{username}/update")
    public ResponseEntity<User> updateUser(@PathVariable("username") String uname, @RequestBody User u){


        User foundUser = userService.findUserByuserName(uname);
        foundUser.setFirstName(u.getFirstName());
        foundUser.setLastName(u.getLastName());
        foundUser.setUserName(u.getUserName());
        foundUser.setSalt(u.getSalt());
        foundUser.setPassword(u.getPassword());
        foundUser.setEmailAddress(u.getEmailAddress());



        User s = userService.UpdateUser(foundUser);

        return new  ResponseEntity<>(s, HttpStatus.OK);





    }






}
