package com.example.tmdt.service;

import com.example.tmdt.dto.BillDetailDTO;

import java.util.List;

public interface IBillDetailService extends BaseService<BillDetailDTO> {
    void addToBill(List<Long> idCartDetails);
    List<BillDetailDTO> showBillByAccount(Long idAccount);

    void saveToBill(List<BillDetailDTO> billDetailDTOS , Long idAccount);

}
