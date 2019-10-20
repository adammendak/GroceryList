package com.grocerylist.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "DISH")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private List<Ingredient> ingredients;
//    private String description;
//    private int prepareTime;
//    private String difficultyLevel;
//    private int numberOfServings;
//    private List<DishCategory> categories;
//    private String photoURL;

}
