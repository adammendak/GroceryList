package com.grocerylist.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PRODUCT_CATEGORY")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private String name;
}
