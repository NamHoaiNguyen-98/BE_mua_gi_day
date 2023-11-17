package com.example.tmdt.repository;
import com.example.tmdt.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    @Query(value = "SELECT * FROM shop AS s WHERE s.account_id = :id",nativeQuery = true)
    Shop findShopByIdAccount(@Param("id") Long id);

    Shop findAllByAccountId(Long id);


}
