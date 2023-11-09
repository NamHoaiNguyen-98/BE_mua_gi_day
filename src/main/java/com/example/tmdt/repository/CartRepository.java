package com.example.tmdt.repository;

import com.example.tmdt.model.buyPrd.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
