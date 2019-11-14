package com.grocerylist.core.controller;

import com.grocerylist.core.service.IngredientService;
import com.grocerylist.dto.IngredientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/ingredient")
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService ingredientService;

    @GetMapping(value = "/{id}")
    public ResponseEntity getIngredient(@PathVariable Long id) {
        //todo Implement in dish service
        return null;
    }

    @GetMapping
    public ResponseEntity getAllIngredients() {
        //todo Implement in dish service
        return null;
    }

    @PostMapping
    public ResponseEntity createIngredient(@Valid @RequestBody IngredientDto ingredientDto) {
        //todo Implement in dish service
        return null;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateIngredient(@Valid @RequestBody IngredientDto ingredientDto) {
        //todo Implement
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteIngredient(@PathVariable Long id) {
        //todo Implement
        return null;
    }
}
