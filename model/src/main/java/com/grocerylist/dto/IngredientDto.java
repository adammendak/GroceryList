package com.grocerylist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.grocerylist.model.Product;
import lombok.Getter;

@Getter
public class IngredientDto {

    @JsonProperty ("id")
    private Long id;
    @JsonProperty ("name")
    private String name;
//    @JsonProperty ("unit")
//    private String unit;
    @JsonProperty ("quantity")
    private double quantity;
    @JsonProperty ("product")
    private Product product;


}
