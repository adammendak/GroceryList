package com.grocerylist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Dish {

    //TODO DELETE, use model module

    private Long id;
    private List<String> categoriesList;
    private Integer difficultyLevel;
    private String recipe;
    private List<Ingredient> ingredients;
}

