package com.example.tmdt.repository;
import com.example.tmdt.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM product  " +
            "WHERE product.status = 0 ",nativeQuery = true)
    List<Product> findAllStatus();
}
