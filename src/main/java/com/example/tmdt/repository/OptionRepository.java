package com.example.tmdt.repository;
import com.example.tmdt.model.OptionProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends  JpaRepository<OptionProduct, Long> {
}
