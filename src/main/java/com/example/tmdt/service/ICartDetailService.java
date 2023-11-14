package com.example.tmdt.service;

import com.example.tmdt.dto.CartDetailDTO;

import java.util.List;

public interface ICartDetailService extends BaseService<CartDetailDTO> {
    void addToCart(CartDetailDTO cartDetailDTO, Long idAccount);
    List<CartDetailDTO> showCart(Long idAccount);
    void deleteProductFromCart(Long idCartDetail);
   void deleteAllProductFromCart(Long idCart);
   void updateQuantityFromCart(Double quantity, Long idProduct, Long idCart);


    List<CartDetailDTO> displayListBuy(Long idShop , String confirm);
    List<CartDetailDTO> displayAllOrder(Long idShop);

}
