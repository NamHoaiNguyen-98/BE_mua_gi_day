package com.example.tmdt.repository;
import com.example.tmdt.model.buyPrd.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
