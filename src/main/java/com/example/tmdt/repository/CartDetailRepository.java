package com.example.tmdt.repository;

import com.example.tmdt.model.buyPrd.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {
}
