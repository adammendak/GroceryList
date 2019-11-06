package com.grocerylist.remote.dto;

import com.grocerylist.model.Dish;
import com.grocerylist.model.Ingredient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DishMapper {
    //TODO move to MODEL/mapper module
    private IngredientMapper ingredientMapper;

    public DishMapper(IngredientMapper ingredientMapper) {
        this.ingredientMapper = ingredientMapper;
    }

    public Dish mapToDish(DishDto dishDto) {
        List<Ingredient> ingredients = dishDto
                .getIngredients()
                .stream()
                .map(ingredientDto -> ingredientMapper.mapToIngredient(ingredientDto))
                .collect(Collectors.toList());
        Dish dish = new Dish();
        dish.setCategoriesList(dishDto.getCategoriesList());
        dish.setIngredients(ingredients);
        dish.setDifficultyLevel(dishDto.getDifficultyLevel());
        dish.setRecipe(dishDto.getRecipe());
        return dish;


    }
}
