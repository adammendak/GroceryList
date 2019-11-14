package com.grocerylist.mapper;

import com.grocerylist.dto.IngredientDto;
import com.grocerylist.model.Ingredient;
import org.mapstruct.Mapper;

@Mapper
public interface IngredientMapper {

    Ingredient toEntity(IngredientDto dto);
    IngredientDto toDto(Ingredient entity);
}
