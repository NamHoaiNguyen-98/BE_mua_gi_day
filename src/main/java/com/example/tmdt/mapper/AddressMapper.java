package com.example.tmdt.mapper;

import com.example.tmdt.dto.AddressDTO;
import com.example.tmdt.model.address.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface AddressMapper extends EntityMapper<AddressDTO, Address> {
}
