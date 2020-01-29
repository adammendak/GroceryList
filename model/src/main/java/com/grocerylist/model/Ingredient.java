package com.grocerylist.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
/**
 * @author  Adam Mendak
 * @version 1.0
 * @since   2019-10-19
 *
 *  Abstract class which contains fields for holding entered ingredient data
 */
@Data
@Entity
@Table(name = "INGREDIENT")
public class Ingredient extends AbstractTimestampableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "QUANTITY")
    private Double quantity;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToMany(mappedBy = "ingredients")
    private List<Dish> dishes;

}
