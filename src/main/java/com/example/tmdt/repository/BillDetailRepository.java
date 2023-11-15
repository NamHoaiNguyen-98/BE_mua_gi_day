package com.example.tmdt.repository;

import com.example.tmdt.model.buyPrd.Bill;
import com.example.tmdt.model.buyPrd.BillDetail;
import com.example.tmdt.model.buyPrd.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import java.util.List;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, Long> {
    @Query(value = "SELECT * FROM bill_detail bd JOIN bill on bd.bill_id = bill.id WHERE account_id = :idAccount", nativeQuery = true)
    List<BillDetail> showBillByAccount(@Param("idAccount") Long idAccount);
    @Query(value = "SELECT * FROM bill WHERE  shop_id = :idShop", nativeQuery = true)
    List<BillDetail> findBillDetailByShop(@Param("idShop") Long idShop);

    List<BillDetail> findAllByProduct_Shop_Id(Long idShop);
    @Query(value = "select * from bill_detail\n" +
            "            inner join product on bill_detail.product_id = product.id\n" +
            "            inner join bill on bill_detail.bill_id = bill.id where product.shop_id = :idShop and bill.status = :status\n" +
            ";" , nativeQuery = true)
    List<BillDetail> displayBillOfShop(@Param("idShop") Long idShop ,@Param("status") String status);
}
