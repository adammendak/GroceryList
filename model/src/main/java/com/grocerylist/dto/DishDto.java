package com.grocerylist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.grocerylist.model.DishCategory;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DishDto {

    @JsonProperty("categoriesList")
    private List<DishCategory> categoriesList = new ArrayList<>();
    @JsonProperty("difficultyLevel")
    private Integer difficultyLevel;
    @JsonProperty("recipe")
    private String recipe;
    @JsonProperty("ingredients")
    private List<IngredientDto> ingredients = new ArrayList<>();
}
