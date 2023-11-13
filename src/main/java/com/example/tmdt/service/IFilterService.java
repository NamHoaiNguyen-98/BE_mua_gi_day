package com.example.tmdt.service;

import com.example.tmdt.model.Filter;
import com.example.tmdt.model.Product;

import java.util.List;

public interface IFilterService {
    List<Product> searchFilter(Filter filter);
}
