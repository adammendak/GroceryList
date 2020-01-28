package com.grocerylist.mapper;

import com.grocerylist.dto.ProductDto;
import com.grocerylist.model.Product;
import org.mapstruct.Mapper;

/**
 * @author Adam Mendak
 * @version 1.0
 * @since 2019-11-14
 * <p>
 * this is interface using for transfer simple object to DTO
 */
@Mapper
public interface ProductMapper {

    Product toEntity(ProductDto dto);

    ProductDto toDto(Product entity);
}
