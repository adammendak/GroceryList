package com.grocerylist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductCategoryDto {

    @JsonProperty("name")
    private String name;

}
