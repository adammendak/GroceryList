package com.grocerylist.remote.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DishDto {
    //TODO move to MODEL/dto module
    @JsonProperty("categories")
    private List<String> categoriesList = new ArrayList<>();
    @JsonProperty("difficultyLevel")
    private Integer difficultyLevel;
    @JsonProperty("recipe")
    private String recipe;
    @JsonProperty("ingredients")
    private List<IngredientDto> ingredients = new ArrayList<>();
}
