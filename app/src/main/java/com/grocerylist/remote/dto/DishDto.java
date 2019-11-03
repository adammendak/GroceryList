package com.grocerylist.remote.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;
@Getter
public class DishDto {
    private List<String> categoriesList;
    @JsonProperty("difficultyLevel")
    private Integer difficultyLevel;
    @JsonProperty("recipe")
    private String recipe;
    @JsonProperty("ingredients")
    private List<IngredientDto> ingredients;


}
