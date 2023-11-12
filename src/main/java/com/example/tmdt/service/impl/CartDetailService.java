package com.example.tmdt.service.impl;


import com.example.tmdt.dto.CartDetailDTO;
import com.example.tmdt.mapper.CartDetailMapper;
import com.example.tmdt.mapper.ProductMapper;
import com.example.tmdt.model.Product;
import com.example.tmdt.model.buyPrd.Cart;
import com.example.tmdt.model.buyPrd.CartDetail;
import com.example.tmdt.model.fkProduct.Category;
import com.example.tmdt.repository.CartDetailRepository;

import com.example.tmdt.repository.CartRepository;
import com.example.tmdt.security.model.Account;
import com.example.tmdt.security.repository.IAccountRepository;
import com.example.tmdt.service.ICartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CartDetailService implements ICartDetailService {
    @Autowired
    private CartDetailRepository cartDetailRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartDetailMapper cartDetailMapper;
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private ProductMapper productMapper;


    @Override
    public void save(CartDetailDTO dto) {
        CartDetail cartDetail = cartDetailMapper.toEntity(dto);
        cartDetailMapper.toDto(cartDetailRepository.save(cartDetail));

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public CartDetailDTO findOne(Long id) {
        Optional<CartDetail> optionalCartDetail = cartDetailRepository.findById(id);
        if (optionalCartDetail.isPresent()) {
            CartDetail cartDetail = optionalCartDetail.get();
            return cartDetailMapper.toDto(cartDetail);
        }
        return null;
    }

    @Override
    public List<CartDetailDTO> findAll() {
        return null;
    }

    //    @Override
//    public void addToCart(CartDetailDTO cartDetailDTO, Long idAccount) {
//        CartDetail cartDetail = cartDetailMapper.toEntity(cartDetailDTO);
//        try {
//            if (cartDetail.getId() == null) {
//                Cart cart = new Cart();
//                Optional<Account> optionalAccount = accountRepository.findById(idAccount);
//                if (optionalAccount.isPresent()) {
//                    Account account = optionalAccount.get();
//                    cart.setAccount(account);
//                }
//                cartRepository.save(cart);
//                cartDetail.setCart(cart);
//                cartDetailRepository.save(cartDetail);
//            } else {
//                Optional<Cart> optionalCart = cartRepository.findById(cartDetailDTO.getCart().getId());
//                if (optionalCart.isPresent()) {
//                    Cart cart = optionalCart.get();
//                    Optional<CartDetail> optionalCartDetail = cartDetailRepository.findCartDetailByCartAndProduct(
//                            cartDetail.getCart().getId(), cartDetail.getProduct().getId());
//                    if (optionalCartDetail.isPresent()) {
//                        CartDetail cartDetailExist = optionalCartDetail.get();
//                        cartDetailExist.setQuantity(cartDetailExist.getQuantity() + cartDetail.getQuantity());
//                        cartDetailRepository.save(cartDetailExist);
//                    } else {
//                        cartDetail.setCart(cart);
//                        cartDetailRepository.save(cartDetail);
//                    }
//                }
//            }
//        }catch (Exception e) {
//            e.getStackTrace();
//        }
//
//
//    }
    public void addToCart(CartDetailDTO cartDetailDTO, Long idAccount) {
        Optional<Cart> cartOptional = cartRepository.findCartByIdAccount(idAccount);
        Cart cart;
        if (cartOptional.isPresent()) {
            cart = cartOptional.get();
        } else {
            cart = new Cart();
            Optional<Account> optionalAccount = accountRepository.findById(idAccount);
            if (optionalAccount.isPresent()) {
                Account account = optionalAccount.get();
                cart.setAccount(account);
                cart.setConfirm("0");
            }
            cartRepository.save(cart);
        }
        Optional<CartDetail> cartDetailOptional = cartDetailRepository.findCartDetailByCartAndProduct(
                cart.getId(), cartDetailDTO.getProduct().getId());
        CartDetail cartDetail;
        if (cartDetailOptional.isPresent()) {
            cartDetail = cartDetailOptional.get();
            cartDetail.setQuantity(cartDetail.getQuantity() + cartDetailDTO.getQuantity());
        } else {
            cartDetail = new CartDetail();
            cartDetail.setQuantity(cartDetailDTO.getQuantity());
            Product product = productMapper.toEntity(cartDetailDTO.getProduct());
            cartDetail.setProduct(product);
            cartDetail.setCart(cart);
        }
        cartDetailRepository.save(cartDetail);
    }

    @Override
    public List<CartDetailDTO> showCart(Long idAccount) {
        List<CartDetail> cartDetails = cartDetailRepository.showCart(idAccount);
        return cartDetailMapper.toDto(cartDetails);
    }
}
