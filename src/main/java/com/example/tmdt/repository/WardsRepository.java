package com.example.tmdt.repository;
import com.example.tmdt.model.address.Wards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WardsRepository extends JpaRepository<Wards, Long> {
}
