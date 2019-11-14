package com.grocerylist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("unit")
    private String unit;

    @JsonProperty("productCategory")
    private ProductCategoryDto productCategory;
}
