package com.example.tmdt.controller;

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
@RequestMapping("/api/carts")
public class CartController {
    @Autowired
    private ICartDetailService cartDetailService;
    @Autowired
    private ICartService cartService;

    @PostMapping("/add")
    ResponseEntity<?> addToCart(@RequestBody CartDetailDTO cartDetailDTO,
                                @RequestParam("idAccount") Long idAccount) {
        cartDetailService.addToCart(cartDetailDTO, idAccount);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    ResponseEntity<List<CartDetailDTO>> showCart(@PathVariable("id") Long idAccount) {
        List<CartDetailDTO> cartDetailDTOS = cartDetailService.showCart(idAccount);
        return new ResponseEntity<>(cartDetailDTOS, HttpStatus.OK);
    }

}
