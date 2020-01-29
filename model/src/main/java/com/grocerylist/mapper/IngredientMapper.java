package com.grocerylist.mapper;

import com.grocerylist.dto.IngredientDto;
import com.grocerylist.model.Ingredient;
import org.mapstruct.Mapper;

/**
 * @author Adam Mendak
 * @version 1.0
 * @since 2019-11-14
 * <p>
 * this is interface using for transfer simple object to DTO
 */
@Mapper
public interface IngredientMapper {

    Ingredient toEntity(IngredientDto dto);

    IngredientDto toDto(Ingredient entity);
}
