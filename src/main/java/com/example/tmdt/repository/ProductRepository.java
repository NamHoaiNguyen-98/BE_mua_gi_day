package com.example.tmdt.repository;
import com.example.tmdt.dto.ProductDTO;
import com.example.tmdt.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByAccount_Id(Long id);


}
