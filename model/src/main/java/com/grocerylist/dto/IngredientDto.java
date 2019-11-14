package com.grocerylist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class IngredientDto {

    @JsonProperty ("quantity")
    private Double quantity;

    @JsonProperty ("product")
    private ProductDto product;
}
