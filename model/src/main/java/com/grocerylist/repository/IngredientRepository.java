package com.grocerylist.repository;

import com.grocerylist.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Adam Mendak
 * @version 1.0
 * @return Ingredient type of optional
 * This interface is a description of the actions that ingredient can do
 * @since 2019-10-20
 * <p>
 * This interface consists exclusively of method which used for data transmission in IngredientService.class from core module
 */
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Optional<Ingredient> findById(String name);
}
