package com.grocerylist.core.controller;

import com.grocerylist.core.exception.ResourceNotFoundException;
import com.grocerylist.core.service.DishCategoryService;
import com.grocerylist.dto.DishCategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Elżbieta Dutkiewicz
 * @version 1.0
 * @since 2019-17-11
 * This class contains methods for manage dish categories database
 */
@RestController
@RequestMapping("/api/dishCategory")
@RequiredArgsConstructor
public class DishCategoryController {

    private final DishCategoryService dishCategoryService;

    /**
     * getDishCategory() method accepts the request for GET
     *
     * @param id
     * @return ResponseEntity
     * @throws ResourceNotFoundException
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity getDishCategory(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dishCategoryService.findById(id));
    }
    /**
     * getAllDishCategories() method accepts the request for GET
     *
     * @return ResponseEntity
     */
    @GetMapping
    public ResponseEntity getAllDishCategories() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dishCategoryService.findAll());
    }
    /**
     * createDishCategory() method accepts the request for POST
     *
     * @param dishDto
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity createDishCategory(@Valid @RequestBody DishCategoryDto dishDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(dishCategoryService.save(dishDto));
    }
    /**
     * updateDishCategory() method accepts the request for PUT
     *
     * @param dishDto
     * @return ResponseEntity
     */
    @PutMapping
    public ResponseEntity updateDishCategory(@Valid @RequestBody DishCategoryDto dishDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(dishCategoryService.save(dishDto));
    }
    /**
     * deleteDishCategory() method accepts the request for DELETE
     *
     * @param id
     * @throws ResourceNotFoundException
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteDishCategory(@PathVariable Long id) throws ResourceNotFoundException {
        dishCategoryService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Dish Category Deleted");
    }
}
