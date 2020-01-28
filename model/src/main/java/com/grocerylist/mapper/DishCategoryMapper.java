package com.grocerylist.mapper;

import com.grocerylist.dto.DishCategoryDto;
import com.grocerylist.model.DishCategory;
import org.mapstruct.Mapper;
/**
 * @author  Adam Mendak
 * @version 1.0
 * @since   2019-11-14
 *
 * this is interface using for transfer simple object to DTO
 */

@Mapper
public interface DishCategoryMapper {

    DishCategory toEntity(DishCategoryDto dto);
    DishCategoryDto toDto(DishCategory entity);
}
