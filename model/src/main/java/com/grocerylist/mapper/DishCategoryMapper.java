package com.grocerylist.mapper;

import com.grocerylist.dto.DishCategoryDto;
import com.grocerylist.dto.DishDto;
import com.grocerylist.model.Dish;
import com.grocerylist.model.DishCategory;
import com.grocerylist.model.Ingredient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DishCategoryMapper {


    public DishCategory mapToDishCategory(DishCategoryDto dishcategoryDto) {
        DishCategory dishCategory = new DishCategory();
        dishCategory.setId(dishcategoryDto.getId());
        dishCategory.setName(dishcategoryDto.getName());

        return dishCategory;

    }
}
