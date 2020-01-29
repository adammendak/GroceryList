package com.grocerylist.repository;

import com.grocerylist.model.Dish;
import com.grocerylist.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Adam Mendak
 * @version 1.0
 * @extends JpaRepository
 * This interface consists exclusively of methods used for data transmission in DishService.class from core module,
 * which @returns Dish type of objects and lists
 *
 * <p>
 * This interface is a description of the actions that dish can do
 * @since 2019-10-20
 */
public interface DishRepository extends JpaRepository<Dish, Long> {

    List<Dish> findByCategories_Name(String name);
}
