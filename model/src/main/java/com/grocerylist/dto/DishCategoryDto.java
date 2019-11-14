package com.grocerylist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DishCategoryDto {

    @JsonProperty("name")
    private String name;

}
