package com.grocerylist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Adam Mendak
 * @version 1.0
 * @since 2019-11-14
 * This class contains data structure type (DTO) for Ingredient
 * It contains only field which are managed by service.class
 */
@Data
public class IngredientDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("quantity")
    @NotNull
    private Double quantity;

    @JsonProperty("product")
    @NotNull
    private ProductDto product;

}
