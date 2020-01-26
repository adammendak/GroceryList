package com.grocerylist.repository;

import com.grocerylist.model.Dish;
import com.grocerylist.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long> {

    List<Dish> findByCategories_Name(String name);
}
