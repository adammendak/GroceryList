package com.grocerylist.core.controller;

import com.grocerylist.core.exception.ResourceNotFoundException;
import com.grocerylist.core.service.DishService;
import com.grocerylist.dto.DishDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Adam Mendak
 * @version 1.0
 * @since 3.12.2019
 * This class contains methods for manage dishes database
 */
@RestController
@RequestMapping("/api/dish")
@RequiredArgsConstructor
public class DishController {

    private final DishService dishService;

    /**
     * getDish() method accepts the request for GET.
     * This method invoke dishService to fetch information about dish from database.
     *
     * @param id
     * @return ResponseEntity
     * @throws ResourceNotFoundException
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity getDish(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dishService.findById(id));
    }

    /**
     * getAllDish() method accepts the request for GET
     * This method invoke dishService to fetch information about dish from database.
     *
     * @return ResponseEntity
     */
    @GetMapping
    public ResponseEntity getAllDishes() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dishService.findAll());
    }

    /**
     * getProductsForName() method accepts the request for GET
     * This method invoke dishService to fetch information about dish from database.
     *
     * @param name
     * @return ResponseEntity
     */
    @GetMapping(value = "/getByName/{name}")
    public ResponseEntity getProductsForName(@PathVariable String name) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dishService.findByDishCategory(name));
    }

    /**
     * createDish() method accepts the request for POST
     *
     * @param dishDto
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity createDish(@Valid @RequestBody DishDto dishDto) throws ResourceNotFoundException {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(dishService.save(dishDto));
    }

    /**
     * updateDish() method accepts the request for PUT
     *
     * @param dishDto
     * @return ResponseEntity
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity updateDish(@Valid @RequestBody DishDto dishDto, @PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dishService.update(dishDto, id));
    }

    /**
     * deleteDish() method accepts the request for DELETE
     *
     * @param id
     * @throws ResourceNotFoundException
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteDish(@PathVariable Long id) throws ResourceNotFoundException {
        dishService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Product Deleted");
    }
}
