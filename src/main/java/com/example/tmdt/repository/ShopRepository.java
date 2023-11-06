package com.example.tmdt.repository;
import com.example.tmdt.model.fkProduct.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
