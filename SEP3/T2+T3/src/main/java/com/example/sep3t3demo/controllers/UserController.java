package com.example.sep3t3demo.controllers;

import com.example.sep3t3demo.res.User;
import com.example.sep3t3demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sep3")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUserBy() {
        List<User> userList = service.findAll();
        System.out.println("done");

        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }

    @PostMapping("/postUser")
    public String postUser(@RequestBody User user) {
        User user1 = new User(user.getUsername(), user.getPassword(), user.getEmail());
        service.postUser(user1);
        return "Done";
    }

    @GetMapping("/getUserByUsername")
    public ResponseEntity<User> getUserByUsername(@RequestParam("username") String username) {

        User user = service.getUserByUsername(username);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
