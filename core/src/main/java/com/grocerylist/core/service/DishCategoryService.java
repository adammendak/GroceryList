package com.grocerylist.core.service;

import com.grocerylist.dao.repository.DishCategoryRepository;
import com.grocerylist.model.Dish;
import com.grocerylist.model.DishCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service

public class DishCategoryService {

    private DishCategoryRepository dishCategoryRepository;


//    public DishCategoryService(DishCategoryRepository dishCategoryRepository) {
//        this.dishCategoryRepository = dishCategoryRepository;
//    }

    public void addDishCategory (DishCategory dishCategory){
        //TODO: to implements
    }
    public void updateDishCategory(DishCategory dishCategory){
        //TODO: to implements
    }

}
