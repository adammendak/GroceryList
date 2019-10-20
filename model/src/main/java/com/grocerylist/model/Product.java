package com.grocerylist.model;

import com.grocerylist.constants.Unit;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private String name;
//    private ProductCategory category;
//    private List<Unit> defaultUnits;

}
