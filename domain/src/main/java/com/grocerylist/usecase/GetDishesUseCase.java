package com.grocerylist.usecase;

import com.grocerylist.model.Dish;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetDishesUseCase {
    //TODO DELETE, use service in core/services module, there are already repositories set up
    // get dishes
    public List<Dish> getDishes(List<String> categoriesList, Integer difficultyLevel) {
        return null;

        //TODO: add dish to database


    }
}
