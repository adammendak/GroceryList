package com.grocerylist.core.controller;

import com.grocerylist.core.service.DishCategoryService;
import com.grocerylist.core.service.DishService;
import com.grocerylist.dto.DishCategoryDto;
import com.grocerylist.dto.DishDto;
import com.grocerylist.model.DishCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/dish")
@RequiredArgsConstructor
public class DishCategoryController {

    private final DishCategoryService dishCategoryService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<DishCategoryDto> getDishCategory(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(dishCategoryService.findById(id));
    }

    @GetMapping
    public ResponseEntity getAllDishCategories() {
        //todo Implement in dish service
        return null;
    }

    @PostMapping
    public ResponseEntity createDishCategory(@Valid @RequestBody DishDto dishDto) {
        //todo Implement in dish service
        return null;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateDishCategory(@Valid @RequestBody DishDto dishDto) {
        //todo Implement
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteDishCategory(@PathVariable Long id) {
        //todo Implement
        return null;
    }
}
