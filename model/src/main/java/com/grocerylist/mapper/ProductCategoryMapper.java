package com.grocerylist.mapper;

import com.grocerylist.dto.ProductCategoryDto;
import com.grocerylist.model.ProductCategory;
import org.mapstruct.Mapper;

/**
 * @author Adam Mendak
 * @version 1.0
 * @since 2019-11-14
 * <p>
 * this is interface using for transfer simple object to DTO
 */
@Mapper
public interface ProductCategoryMapper {

    ProductCategory toEntity(ProductCategoryDto dto);

    ProductCategoryDto toDto(ProductCategory entity);

}
