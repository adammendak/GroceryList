package com.grocerylist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
/**
 * @author  Adam Mendak
 * @version 1.0
 * @since   2019-11-14
 * This class contains data structure type (DTO) for Dish
 * It contains only field which are managed by service.class
 */
@Data
public class DishDto {

    @JsonProperty("id")
    private Long id;

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

    @JsonProperty("categories")
    private List<DishCategoryDto> categories;

    @JsonProperty("ingredients")
    private List<IngredientDto> ingredients;
}
