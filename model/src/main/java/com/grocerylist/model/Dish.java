package com.grocerylist.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

@Data
@Entity
@Table(name = "DISH")
public class Dish extends AbstractTimestampableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RECIPE")
    private String recipe;

    @Column(name = "PREPARE_TIME")
    private Integer prepareTime;

    @Column(name = "DIFFICULTY_LEVEL")
    private Integer difficultyLevel;

    @Column(name = "NUMBER_OF_SERVINGS")
    private Integer numberOfServings;

    @Column(name = "PHOTO_URL")
    private String photoURL;

    @ManyToMany
    @JoinTable(name = "DISH_DISH_CATEGORY",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_category_id")
    )
    private List<DishCategory> categoriesList;

    @ManyToMany
    @JoinTable(name = "DISH_INGREDIENT",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<Ingredient> ingredients;


}
