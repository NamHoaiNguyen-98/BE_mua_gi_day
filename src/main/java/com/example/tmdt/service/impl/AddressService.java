package com.example.tmdt.service.impl;

import com.example.tmdt.mapper.AddressMapper;

import com.example.tmdt.dto.AddressDTO;
import com.example.tmdt.model.address.Address;
import com.example.tmdt.repository.AddressRepository;

import com.example.tmdt.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IAddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public void save(AddressDTO dto) {
        Address address = addressMapper.toEntity(dto);
        addressMapper.toDto(addressRepository.save(address));
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public AddressDTO findOne(Long id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if(optionalAddress.isPresent()) {
            Address address = optionalAddress.get();
            return addressMapper.toDto(address);
        } return null;
    }

    @Override
    public List<AddressDTO> findAll() {
        List<Address> addresses = addressRepository.findAll();
        return addressMapper.toDto(addresses);
    }


}
