package com.grocerylist.model;

import com.grocerylist.constants.Unit;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "INGREDIENT")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private Product product;
//    private double quantity;
//    private Unit unit;

}
