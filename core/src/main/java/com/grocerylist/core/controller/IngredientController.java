package com.grocerylist.core.controller;

import com.grocerylist.core.exception.ResourceNotFoundException;
import com.grocerylist.core.service.IngredientService;
import com.grocerylist.dto.DishDto;
import com.grocerylist.dto.IngredientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
/**
 * @author Elżbieta Dutkiewicz
 * @version 1.0
 * @since 2020-01-19
 * This class contains methods for manage ingredients database
 */
@RestController
@RequestMapping("/api/ingredient")
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService ingredientService;
    private IngredientDto ingredientDto;
    /**
     * getIngredient() method accepts the request for GET
     *
     * @param id
     * @return ResponseEntity
     * @throws ResourceNotFoundException
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity getIngredient(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ingredientService.findById(id));
    }
    /**
     * getAllIngredient() method accepts the request for GET
     *
     * @return ResponseEntity
     */
    @GetMapping
    public ResponseEntity getAllIngredient() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ingredientService.findAll());
    }
    /**
     * createIngredient() method accepts the request for POST
     *
     * @param ingredientDto
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity createIngredient(@Valid @RequestBody IngredientDto ingredientDto) throws ResourceNotFoundException {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ingredientService.save(ingredientDto));
    }
    /**
     * updateIngredient(() method accepts the request for PUT
     *
     * @param dishDto
     * @param id
     * @return ResponseEntity
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity updateIngredient(@Valid @RequestBody DishDto dishDto, @PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ingredientService.update(ingredientDto, id));
    }
    /**
     * deleteIngredient() method accepts the request for DELETE
     *
     * @param id
     * @throws ResourceNotFoundException
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteIngredient(@PathVariable Long id) throws ResourceNotFoundException {
        ingredientService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Ingredient Deleted");
    }
}


