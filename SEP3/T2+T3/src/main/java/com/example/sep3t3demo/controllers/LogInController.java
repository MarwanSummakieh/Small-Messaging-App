package com.example.sep3t3demo.controllers;

import com.example.sep3t3demo.service.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sep3/login")
public class LogInController {

    @Autowired
    private LogInService service;

    @PostMapping("/user")
    public ResponseEntity<Void> getValidateUser(@RequestParam("username") String username,
                                                    @RequestParam("password") String password) {
        boolean valid = service.userAuthentication(username, password);
        if (!valid)
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }
}
