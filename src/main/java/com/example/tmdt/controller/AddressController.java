package com.example.tmdt.controller;

import com.example.tmdt.dto.AddressDTO;
import com.example.tmdt.service.impl.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/addresses")

public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    ResponseEntity<List<AddressDTO>> findAll() {
        List<AddressDTO> addressDTOS = addressService.findAll();
        return new ResponseEntity<>(addressDTOS, HttpStatus.OK);
    }

    @GetMapping("/id")
    ResponseEntity<AddressDTO> findOne(@Param("id") Long id) {
        AddressDTO addressDTO = addressService.findOne(id);
        return new ResponseEntity<>(addressDTO, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<?> save(@RequestBody AddressDTO addressDTO) {
        addressService.save(addressDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
