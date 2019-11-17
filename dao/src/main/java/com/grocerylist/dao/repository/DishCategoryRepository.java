package com.grocerylist.dao.repository;

import com.grocerylist.model.DishCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DishCategoryRepository extends CrudRepository<DishCategory, Long> {

    Optional<DishCategory> findById(Long id);
    List<DishCategory> findAll();

//    List <DishCategory fin

}
