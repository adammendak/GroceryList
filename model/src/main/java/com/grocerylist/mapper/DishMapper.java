package com.grocerylist.mapper;

import com.grocerylist.dto.DishDto;
import com.grocerylist.model.Dish;
import com.grocerylist.model.Ingredient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DishMapper {

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
