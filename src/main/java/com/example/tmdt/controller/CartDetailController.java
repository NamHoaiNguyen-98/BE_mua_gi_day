package com.example.tmdt.controller;

import com.example.tmdt.dto.CartDTO;
import com.example.tmdt.dto.CartDetailDTO;
import com.example.tmdt.service.ICartDetailService;

import com.example.tmdt.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cartDetails")
public class CartDetailController {
    @Autowired
    private ICartDetailService cartDetailService;
    @Autowired
    private ICartService cartService;
    @GetMapping("/shop/{idShop}")
    ResponseEntity<List<CartDetailDTO>> showCart(@PathVariable("idShop") Long idShop) {
        List<CartDetailDTO> cartDetailDTOS = cartDetailService.displayListBuy(idShop , "1");
        return new ResponseEntity<>(cartDetailDTOS, HttpStatus.OK);
    }
    @PostMapping("/changeOrder")
    ResponseEntity<?> changeCartDetails(@RequestBody CartDTO cartDTO) {
        cartService.save(cartDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}