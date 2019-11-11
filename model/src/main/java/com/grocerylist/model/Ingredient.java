package com.grocerylist.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
@Table(name = "INGREDIENT")
public class Ingredient extends AbstractTimestampableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "QUANTITY")
    private Double quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToMany(mappedBy = "ingredients")
    private List<Dish> dishes;

}
