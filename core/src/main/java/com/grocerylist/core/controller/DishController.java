package com.grocerylist.core.controller;

import com.grocerylist.core.service.DishService;
import com.grocerylist.dto.DishDto;
import com.grocerylist.dto.DishSpecifyRequestDto;
import com.grocerylist.mapper.DishMapper;
import com.grocerylist.model.Dish;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/dish")
@RequiredArgsConstructor


public class DishController {

    //TODO remove getDishesUseCase , use DishService from core/services

    private DishMapper dishMapper;
    private DishService dishService;

    public DishController(DishMapper dishMapper, DishService dishService) {
        this.dishMapper = dishMapper;
        this.dishService = dishService;

    }

    @PostMapping("/add-dish")
    public ResponseEntity<String> addDish(@RequestBody DishDto dishDto) {
        if (dishDto.getIngredients().isEmpty()
                || dishDto.getCategoriesIdList().isEmpty()
                || Objects.isNull(dishDto.getDifficultyLevel())
                || Objects.isNull(dishDto.getRecipe())) {
            return new ResponseEntity("Your request body is not correct", HttpStatus.BAD_REQUEST);
        }
        Dish dish = dishMapper.mapToDish(dishDto);
//        processDishUseCase.run(dish);
        return null;
        //TODO: implement service insert record to DataBase
    }

   @GetMapping("/get-dishes")
    public ResponseEntity<List<DishDto>> getDishes(@RequestBody DishSpecifyRequestDto dishSpecifyRequestDto) {
//        getDishesUseCase.getDishes(dishSpecifyRequestDto.getCategoriesList(), dishSpecifyRequestDto.getDifficultyLevel());
        return null;


    }
}
