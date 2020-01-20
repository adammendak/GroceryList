package com.grocerylist.mapper;

import com.grocerylist.dto.ProductCategoryDto;
import com.grocerylist.model.ProductCategory;
import org.mapstruct.Mapper;

@Mapper
public interface ProductCategoryMapper {

    ProductCategory toEntity(ProductCategoryDto dto);
    ProductCategoryDto toDto(ProductCategory entity);

}
