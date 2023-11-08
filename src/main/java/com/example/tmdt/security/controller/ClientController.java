package com.example.tmdt.security.controller;


import com.example.tmdt.model.User;
import com.example.tmdt.security.DTO.sdi.ClientSdi;
import com.example.tmdt.security.service.ClientService;
import com.example.tmdt.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private IUserService userService;

    @PostMapping(value = "create")
    public ResponseEntity<?> create(
            @RequestBody ClientSdi sdi
    ) {
        List<String> email = userService.listNameEmail();
        List<String> acc = userService.listNameUser();

        if(acc.contains(sdi.getUsername()) || email.contains(sdi.getEmail())){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        clientService.create(sdi);
        return ResponseEntity.ok(sdi);
    }
}