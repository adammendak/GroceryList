package com.grocerylist.model;

import lombok.Data;

import java.util.List;

@Data
public class Dish {
    private long id;
    private List<Ingredient> ingredients;
    private String description;
    private int prepareTime;
    private String difficultyLevel;
    private int numberOfServings;
    private List<DishCategory> categories;
    private String photoURL;

}
