package com.grocerylist.core.controller;

import com.grocerylist.core.service.DishCategoryService;
import com.grocerylist.dto.DishCategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/dishCategory")
@RequiredArgsConstructor
public class DishCategoryConroller {

    private final DishCategoryService dishCategoryService;

    @GetMapping(value = "/{id}")
    public ResponseEntity getDish(@PathVariable Long id) {
        //todo Implement in dish service
        return null;
    }

    @GetMapping
    public ResponseEntity getAllDishes() {
        //todo Implement in dish service
        return null;
    }

    @PostMapping
    public ResponseEntity createDish(@Valid @RequestBody DishCategoryDto dishCategoryDto) {
        //todo Implement in dish service
        return null;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateDish(@Valid @RequestBody DishCategoryDto dishCategoryDto) {
        //todo Implement
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteDish(@PathVariable Long id) {
        //todo Implement
        return null;
    }
}
