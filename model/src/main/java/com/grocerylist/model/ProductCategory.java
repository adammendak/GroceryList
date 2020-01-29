package com.grocerylist.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
/**
 * @author  Adam Mendak
 * @version 1.0
 * @since   2019-10-19
 *  *
 *  * Abstract class which contains fields for holding entered product category data
 */
@Data
@Entity
@Table(name = "PRODUCT_CATEGORY")
public class ProductCategory extends AbstractTimestampableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "productCategory")
    private List<Product> products;

}

