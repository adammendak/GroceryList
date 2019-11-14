package com.grocerylist.mapper;

import com.grocerylist.dto.ProductDto;
import com.grocerylist.model.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {

    Product toEntity(ProductDto dto);
    ProductDto toDto(Product entity);
}
