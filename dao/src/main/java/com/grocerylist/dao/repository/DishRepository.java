package com.grocerylist.dao.repository;

import com.grocerylist.model.Dish;
import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, Long> {
}
