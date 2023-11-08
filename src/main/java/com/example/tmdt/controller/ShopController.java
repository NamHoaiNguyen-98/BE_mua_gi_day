package com.example.tmdt.controller;

import com.example.tmdt.dto.AddressDTO;
import com.example.tmdt.dto.ShopDTO;
import com.example.tmdt.service.impl.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/shops")
public class ShopController {
    @Autowired
    private ShopService shopService;
    @GetMapping
    ResponseEntity<List<ShopDTO>> findAll() {
        List<ShopDTO> shopDTOS = shopService.findAll();
        return new ResponseEntity<>(shopDTOS, HttpStatus.OK);
    }

    @GetMapping("/id")
    ResponseEntity<ShopDTO> findOne(@Param("id") Long id) {
        ShopDTO shopDTO = shopService.findOne(id);
        return new ResponseEntity<>(shopDTO, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<?> save(@RequestBody ShopDTO shopDTO) {
        shopService.save(shopDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/account/{id}")
    ResponseEntity<?> findShopByAccount(@PathVariable Long id){
       ShopDTO shopDTO = shopService.findShopByIdAccount(id);
        return new ResponseEntity<>(shopDTO, HttpStatus.OK);
    }
}
