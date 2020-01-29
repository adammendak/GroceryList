package com.grocerylist.model;

import lombok.Data;

import javax.persistence.*;
/**
 * @author  Adam Mendak
 * @version 1.0
 * @since   2019-10-19
 *
 * Abstract class which contains fields for holding entered DishCategory data
 */
@Data
@Entity
@Table(name = "DISH_CATEGORY")
public class DishCategory extends AbstractTimestampableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

}
