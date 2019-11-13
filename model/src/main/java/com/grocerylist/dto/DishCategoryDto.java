package com.grocerylist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

@Getter
public class DishCategoryDto {
   @JsonProperty("id")
    private Long id;
   @JsonProperty("name")
    private String name;

}
