package com.grocerylist.model;

import lombok.Data;

import java.util.List;

@Data
public class Product {
    private long id;
    private String name;
    private ProductCategory category;
    private List<Unit> defaultUnits;

}
