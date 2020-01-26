package com.grocerylist.core.controller;

import com.grocerylist.core.exception.ResourceNotFoundException;
import com.grocerylist.core.service.DishService;
import com.grocerylist.dto.DishDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/dish")
@RequiredArgsConstructor
public class DishController {

    private final DishService dishService;

    @GetMapping(value = "/{id}")
    public ResponseEntity getDish(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dishService.findById(id));
    }

    @GetMapping
    public ResponseEntity getAllDishes() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dishService.findAll());
    }

    @GetMapping(value = "/getByName/{name}")
    public ResponseEntity getProductsForName(@PathVariable String name) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dishService.findByDishCategory(name));
    }

    @PostMapping
    public ResponseEntity createDish(@Valid @RequestBody DishDto dishDto) throws ResourceNotFoundException {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(dishService.save(dishDto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateDish(@Valid @RequestBody DishDto dishDto, @PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dishService.update(dishDto, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteDish(@PathVariable Long id) throws ResourceNotFoundException {
        dishService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Product Deleted");
    }
}
