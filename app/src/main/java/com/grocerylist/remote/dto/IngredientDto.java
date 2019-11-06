package com.grocerylist.remote.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class IngredientDto {
    @JsonProperty ("id")
    private Long id;
    @JsonProperty ("name")
    private String name;
    @JsonProperty ("unit")
    private String unit;
    @JsonProperty ("quantity")
    private int quantity;


}
