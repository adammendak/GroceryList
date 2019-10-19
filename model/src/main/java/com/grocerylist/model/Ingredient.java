package com.grocerylist.model;

import com.grocerylist.constants.Unit;
import lombok.Data;

@Data
public class Ingredient {
    private long id;
    private Product product;
    private double quantity;
    private Unit unit;

}
