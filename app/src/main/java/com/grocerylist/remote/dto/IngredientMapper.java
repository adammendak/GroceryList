package com.grocerylist.remote.dto;

import com.grocerylist.model.Ingredient;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper {
    public Ingredient mapToIngredient (IngredientDto ingredientDto) {
        Ingredient ingredient = new Ingredient();
//        ingredient.setName(ingredientDto.getName());
        ingredient.setName(ingredientDto.getName());
        ingredient.setQuantity(ingredientDto.getQuantity());
        ingredient.setUnit(ingredientDto.getUnit());
        return ingredient;
    }
}
