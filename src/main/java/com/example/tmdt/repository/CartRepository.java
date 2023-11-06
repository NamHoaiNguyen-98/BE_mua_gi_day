package com.example.tmdt.repository;

import com.example.tmdt.model.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Address, Long> {
}
