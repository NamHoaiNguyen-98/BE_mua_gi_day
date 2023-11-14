package com.example.tmdt.service.impl;

import com.example.tmdt.dto.BillDTO;
import com.example.tmdt.mapper.BillMapper;
import com.example.tmdt.model.buyPrd.Bill;
import com.example.tmdt.repository.BillRepository;
import com.example.tmdt.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BillService implements IBillService {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private BillMapper billMapper;
    @Override
    public void save(BillDTO dto) {
        Bill bill = billMapper.toEntity(dto);
        billRepository.save(bill);

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public BillDTO findOne(Long id) {

        return null;
    }

    @Override
    public List<BillDTO> findAll() {
        return null;
    }
}
