package com.example.tmdt.service;

import com.example.tmdt.dto.CartDetailDTO;

import java.util.List;

public interface ICartDetailService extends BaseService<CartDetailDTO> {
    void addToCart(CartDetailDTO cartDetailDTO, Long idAccount);
    List<CartDetailDTO> showCart(Long idAccount);
}
