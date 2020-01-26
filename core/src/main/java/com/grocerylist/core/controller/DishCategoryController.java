package com.grocerylist.core.controller;

import com.grocerylist.core.exception.ResourceNotFoundException;
import com.grocerylist.core.service.DishCategoryService;
import com.grocerylist.dto.DishCategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/dishCategory")
@RequiredArgsConstructor
public class DishCategoryController {

    private final DishCategoryService dishCategoryService;

    @GetMapping(value = "/{id}")
    public ResponseEntity getDishCategory(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dishCategoryService.findById(id));
    }

    @GetMapping
    public ResponseEntity getAllDishCategories() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dishCategoryService.findAll());
    }

    @PostMapping
    public ResponseEntity createDishCategory(@Valid @RequestBody DishCategoryDto dishDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(dishCategoryService.save(dishDto));
    }

    @PutMapping
    public ResponseEntity updateDishCategory(@Valid @RequestBody DishCategoryDto dishDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(dishCategoryService.save(dishDto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteDishCategory(@PathVariable Long id) throws ResourceNotFoundException {
        dishCategoryService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Dish Category Deleted");
    }
}
