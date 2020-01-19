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

@RestController
@RequestMapping("/api/ingredient")
@RequiredArgsConstructor
public class IngredientController {
    private final IngredientService ingredientService;
    private IngredientDto ingredientDto;

    @GetMapping(value = "/{id}")
    public ResponseEntity getIngredient(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ingredientService.findById(id));
    }

    @GetMapping
    public ResponseEntity getAllIngredient() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ingredientService.findAll());
    }

    @PostMapping
    public ResponseEntity createIngredient(@Valid @RequestBody IngredientDto ingredientDto) throws ResourceNotFoundException {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ingredientService.save(ingredientDto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateIngredient(@Valid @RequestBody DishDto dishDto, @PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ingredientService.update(ingredientDto, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteIngredient(@PathVariable Long id) throws ResourceNotFoundException {
        ingredientService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Ingredient Deleted");
    }
}


