package com.eq.demo.controller;

import com.eq.demo.models.User;
import com.eq.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserInfoController {

    private UserService userService;

    public UserInfoController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity home() {
        return new ResponseEntity("Home Page", HttpStatus.OK);
    }


    @GetMapping("/users")
    public ResponseEntity<List<User>> fetchUsers() {
        List<User> users = userService.fetchUsers();
        if(users != null) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/users")
    public ResponseEntity addUser(@RequestBody User user) {
        User savedUser = this.userService.addUser(user);
        if (savedUser != null) {
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
