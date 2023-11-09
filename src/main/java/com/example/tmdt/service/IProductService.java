package com.example.tmdt.service;

import com.example.tmdt.dto.ProductDTO;

import java.util.List;

public interface IProductService extends BaseService<ProductDTO>{
    List<ProductDTO> findAllByAccount_Id(Long id);
    List<ProductDTO> findAllStatus () ;
}
