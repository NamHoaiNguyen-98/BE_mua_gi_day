package com.example.tmdt.service;

import com.example.tmdt.dto.BillDTO;
import com.example.tmdt.dto.BillDetailDTO;
import com.example.tmdt.dto.CartDetailDTO;

import java.util.List;

public interface IBillDetailService extends BaseService<BillDetailDTO> {
    void addToBill(List<Long> idCartDetails);
    List<BillDetailDTO> displayListBuy(Long idShop , String status);
    List<BillDetailDTO> findByShop(Long idShop);

}
