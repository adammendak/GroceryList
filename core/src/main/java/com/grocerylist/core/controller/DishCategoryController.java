package com.grocerylist.core.controller;

import com.grocerylist.core.service.DishCategoryService;
import com.grocerylist.dto.DishCategoryDto;
import com.grocerylist.mapper.DishCategoryMapper;
import com.grocerylist.model.DishCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api/dish-category")
@RequiredArgsConstructor
public class DishCategoryController {

    private DishCategoryMapper dishCategoryMapper;
    private DishCategoryService dishCategoryService;

    public DishCategoryController(DishCategoryMapper dishCategoryMapper, DishCategoryService dishCategoryService) {
        this.dishCategoryMapper = dishCategoryMapper;
        this.dishCategoryService = dishCategoryService;
    }

    @PostMapping("/add-dish-category")
    public ResponseEntity<String> addDishCategory(@RequestBody DishCategoryDto dishCategoryDto) {
        if (Objects.isNull(dishCategoryDto.getName())
                || dishCategoryDto.getName().isEmpty()) {
            return new ResponseEntity("Your request body is not correct", HttpStatus.BAD_REQUEST);
        }
        DishCategory dishCategory = dishCategoryMapper.mapToDishCategory(dishCategoryDto);


        return null;
        //TODO: implement service insert record to DataBase
    }

    @PostMapping("/update-dish-category")
    public ResponseEntity<String> updateDishCategory(@RequestBody DishCategoryDto dishCategoryDto) {
        if (Objects.isNull(dishCategoryDto.getName())
                || dishCategoryDto.getName().isEmpty()
                || Objects.isNull(dishCategoryDto.getId())
        ) {
            return new ResponseEntity("Your request body is not correct", HttpStatus.BAD_REQUEST);


        }

        DishCategory dishCategory = dishCategoryMapper.mapToDishCategory(dishCategoryDto);
        dishCategoryService.updateDishCategory(dishCategory);

        return null;
    }
}