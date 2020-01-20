package com.grocerylist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class IngredientDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty ("quantity")
    @NotNull
    private Double quantity;

    @JsonProperty ("product")
    @NotNull
    private ProductDto product;

}
