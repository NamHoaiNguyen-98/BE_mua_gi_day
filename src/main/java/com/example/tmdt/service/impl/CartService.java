package com.example.tmdt.service.impl;

import com.example.tmdt.dto.CartDTO;
import com.example.tmdt.service.ICartService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartService implements ICartService {
    @Override
    public void save(CartDTO dto) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public CartDTO findOne(Long id) {
        return null;
    }

    @Override
    public List<CartDTO> findAll() {
        return null;
    }
}
