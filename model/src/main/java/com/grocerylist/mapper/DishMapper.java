package com.grocerylist.mapper;

import com.grocerylist.dto.DishDto;
import com.grocerylist.model.Dish;
import org.mapstruct.Mapper;

@Mapper
public interface DishMapper {

    DishDto toDto(Dish entity);
    Dish toEntity(DishDto dto);
}
