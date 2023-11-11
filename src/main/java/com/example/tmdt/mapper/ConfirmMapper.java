package com.example.tmdt.mapper;

import com.example.tmdt.dto.ConfirmDTO;
import com.example.tmdt.model.buyPrd.Confirm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface ConfirmMapper extends EntityMapper<ConfirmDTO, Confirm> {
}
