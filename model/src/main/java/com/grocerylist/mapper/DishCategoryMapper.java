package com.grocerylist.mapper;

import com.grocerylist.dto.DishCategoryDto;
import com.grocerylist.model.DishCategory;
import org.mapstruct.Mapper;

@Mapper
public interface DishCategoryMapper {

    DishCategory toEntity(DishCategoryDto dto);
    DishCategoryDto toDto(DishCategory entity);
}
