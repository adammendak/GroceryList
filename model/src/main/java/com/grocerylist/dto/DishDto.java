package com.grocerylist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DishDto {

    @JsonProperty("description")
    private String description;

    @JsonProperty("prepareTime")
    private Integer prepareTime;

    @JsonProperty("difficultyLevel")
    private String difficultyLevel;

    @JsonProperty("numberOfServings")
    private Integer numberOfServings;

    @JsonProperty("photoURL")
    private String photoURL;

    @JsonProperty("categories")
    private List<DishCategoryDto> categories;

    @JsonProperty("ingredients")
    private List<IngredientDto> ingredients;
}
