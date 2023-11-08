package com.example.tmdt.controller;

import com.example.tmdt.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private IUserService userService ;
    @GetMapping("/email")
    public ResponseEntity<Iterable<String>> findListNameEmail() {
        return new ResponseEntity<>(userService.listNameEmail(), HttpStatus.OK);
    }
    @GetMapping("/user")
    public ResponseEntity<Iterable<String>> findListNameUser() {
        return new ResponseEntity<>(userService.listNameUser(), HttpStatus.OK);
    }
}
