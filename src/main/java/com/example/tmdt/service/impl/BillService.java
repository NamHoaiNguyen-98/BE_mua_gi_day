package com.example.tmdt.service.impl;

import com.example.tmdt.dto.BillDTO;
import com.example.tmdt.service.IBillService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BillService implements IBillService {
    @Override
    public void save(BillDTO dto) {

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
