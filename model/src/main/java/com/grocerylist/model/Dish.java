package com.grocerylist.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "DISH")
public class Dish extends AbstractTimestampableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PREPARE_TIME")
    private Integer prepareTime;

    @Column(name = "DIFFICULTY_LEVEL")
    private String difficultyLevel;

    @Column(name = "NUMBER_OF_SERVINGS")
    private Integer numberOfServings;

    @Column(name = "PHOTO-URL")
    private String photoURL;

    @ManyToMany
    @JoinTable(name = "DISH_DISH_CATEGORY",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_category_id")
    )
    private List<DishCategory> categories;

    @ManyToMany
    @JoinTable(name = "DISH_INGREDIENT",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<Ingredient> ingredients;


}
