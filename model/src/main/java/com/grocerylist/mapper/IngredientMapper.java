package com.grocerylist.mapper;
import com.grocerylist.dto.IngredientDto;
import com.grocerylist.model.Ingredient;
import org.springframework.stereotype.Component;

@Component
class IngredientMapper {

    Ingredient mapToIngredient(IngredientDto ingredientDto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredientDto.getId());
        ingredient.setProduct(ingredientDto.getProduct());
        ingredient.setQuantity(ingredientDto.getQuantity());
//        ingredient.setUnit(ingredientDto.getUnit());
        return ingredient;
    }
}