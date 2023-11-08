package com.example.tmdt.controller;
import com.example.tmdt.dto.ImageDTO;
import com.example.tmdt.dto.ProductDTO;
import com.example.tmdt.service.IImageService;
import com.example.tmdt.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private IImageService imageService;

    @GetMapping
    ResponseEntity<Iterable<ProductDTO>> findAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<ProductDTO> findOne(@PathVariable("id") Long id) {
        ProductDTO productDTO = productService.findOne(id);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }
    @PostMapping
    ResponseEntity<?> save(@RequestBody ProductDTO productDTO) {
        List<ImageDTO> imageDTOS = productDTO.getImage();
        for (ImageDTO imageDTO : imageDTOS) {
            imageService.save(imageDTO);
        }
        productService.save(productDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }


}