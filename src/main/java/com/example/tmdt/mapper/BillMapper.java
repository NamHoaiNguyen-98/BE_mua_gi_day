package com.example.tmdt.mapper;

import com.example.tmdt.dto.BillDTO;
import com.example.tmdt.model.Bill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface BillMapper extends EntityMapper<BillDTO, Bill> {
}
