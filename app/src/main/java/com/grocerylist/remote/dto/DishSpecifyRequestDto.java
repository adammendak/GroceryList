package com.grocerylist.remote.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DishSpecifyRequestDto {
    //TODO move to MODEL/dto module
    @JsonProperty("categories")
    private List<String> categoriesList = new ArrayList<>();
    @JsonProperty("difficultyLevel")
    private Integer difficultyLevel;
}
