package com.example.tmdt.service;

import com.example.tmdt.dto.ShopDTO;
import com.example.tmdt.model.fkProduct.Shop;

public interface IShop extends BaseService<ShopDTO>{
    ShopDTO findShopByIdAccount(Long id);
}
