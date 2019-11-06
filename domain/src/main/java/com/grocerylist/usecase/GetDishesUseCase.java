package com.grocerylist.usecase;

import com.grocerylist.model.Dish;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetDishesUseCase {
    // get dishes
    public List<Dish> getDishes(List<String> categoriesList, Integer difficultyLevel) {
        return null;

        //TODO: add dish to database


    }
}
