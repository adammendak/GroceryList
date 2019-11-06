package com.grocerylist.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class Product {

    //TODO DELETE, use model module

    private Long id;
    private String name;
    private List<Unit> units;
}
