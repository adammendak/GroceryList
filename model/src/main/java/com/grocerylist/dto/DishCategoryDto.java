package com.grocerylist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class DishCategoryDto {

    @JsonProperty("name")
    @NotNull
    @NotEmpty
    private String name;

}
