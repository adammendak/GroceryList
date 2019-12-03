package com.grocerylist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class DishDto {

    @JsonProperty("description")
    @NotNull
    @NotEmpty
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
