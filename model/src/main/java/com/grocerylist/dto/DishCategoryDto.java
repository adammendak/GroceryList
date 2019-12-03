package com.grocerylist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DishCategoryDto {

    @JsonProperty("name")
    @NotNull
    private String name;

}
