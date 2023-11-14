package com.example.tmdt.repository;

import com.example.tmdt.model.buyPrd.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, Long> {
    @Query(value = "SELECT * FROM bill_detail bd JOIN bill on bd.bill_id = bill.id WHERE account_id = :idAccount", nativeQuery = true)
    List<BillDetail> showBillByAccount(@Param("idAccount") Long idAccount);
}
