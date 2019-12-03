package com.grocerylist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.grocerylist.constants.Unit;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ProductDto {

    @JsonProperty("name")
    @NotNull
    @NotEmpty
    private String name;

    @JsonProperty("unit")
    @NotNull
    private String unit;

    @JsonProperty("productCategory")
    @NotNull
    private ProductCategoryDto productCategory;
}
