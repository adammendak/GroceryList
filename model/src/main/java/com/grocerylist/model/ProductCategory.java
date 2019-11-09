package com.grocerylist.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PRODUCT_CATEGORY")
public class ProductCategory extends AbstractTimestampableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;
}
