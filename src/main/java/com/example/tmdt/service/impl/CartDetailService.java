package com.example.tmdt.service.impl;

import com.example.tmdt.dto.CartDetailDTO;
import com.example.tmdt.service.ICartDetailService;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class CartDetailService implements ICartDetailService {
    @Override
    public void save(CartDetailDTO dto) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public CartDetailDTO findOne(Long id) {
        return null;
    }

    @Override
    public List<CartDetailDTO> findAll() {
        return null;
    }
}
