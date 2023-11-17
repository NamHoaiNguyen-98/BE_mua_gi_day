package com.example.tmdt.mapper;

import com.example.tmdt.dto.CategoryDTO;
import com.example.tmdt.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface CategoryMapper extends EntityMapper<CategoryDTO, Category>{
}
