package com.grocerylist.repository;

import com.grocerylist.model.DishCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DishCategoryRepository extends JpaRepository<DishCategory, Long> {

    Optional<DishCategory> findById(Long id);

    List<DishCategory> findAll();

}
