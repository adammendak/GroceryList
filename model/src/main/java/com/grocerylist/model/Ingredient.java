package com.grocerylist.model;

import lombok.Data;

@Data
public class Ingredient {
    private long id;
    private Product product;
    private double quantity;
    private Unit unit;

}
