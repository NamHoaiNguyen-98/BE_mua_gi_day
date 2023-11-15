package com.example.tmdt.repository;
import com.example.tmdt.model.buyPrd.Bill;
import com.example.tmdt.model.buyPrd.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    @Query(value = "SELECT * FROM bill WHERE account_id = :idAccount AND shop_id = :idShop limit 1", nativeQuery = true)
    Optional<Bill> findBillByIdAccount(@Param("idAccount") Long idAccount,
                                       @Param("idShop") Long idShop);

}
