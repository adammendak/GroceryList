package com.grocerylist.mapper;

import com.grocerylist.dto.DishDto;
import com.grocerylist.model.Dish;
import org.mapstruct.Mapper;
/**
 * @author  Adam Mendak
 * @version 1.0
 * @since   2019-11-14
 *
 * this is interface using for transfer simple object to DTO
 */

@Mapper
public interface DishMapper {

    DishDto toDto(Dish entity);
    Dish toEntity(DishDto dto);
}
