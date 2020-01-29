package com.grocerylist.repository;

import com.grocerylist.model.DishCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Elżbieta Dutkiewicz
 * @version 1.0
 * @extends JpaRepository
 * This interface consists exclusively of methods used for data transmission in DishCategoryService.class from core module,
 * which @returns Dish type of objects and lists
 *
 * <p>
 * This interface is a description of the actions that dish category can do
 * @since 2019-11-17
 */
public interface DishCategoryRepository extends JpaRepository<DishCategory, Long> {

    Optional<DishCategory> findById(Long id);

    List<DishCategory> findAll();

    Optional<DishCategory> findByName(String name);

}
