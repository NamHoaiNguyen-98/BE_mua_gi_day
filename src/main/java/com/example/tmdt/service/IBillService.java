package com.example.tmdt.service;

import com.example.tmdt.dto.BillDTO;
import com.example.tmdt.model.buyPrd.BillDetail;

import java.util.List;

public interface IBillService extends BaseService<BillDTO> {
    List<BillDTO> findByShop (Long id) ;
    void accept (List<BillDetail> billDetails) ;
    void rejection (List<BillDetail> billDetails , String reason) ;
}
