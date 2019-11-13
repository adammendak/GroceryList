package com.grocerylist.core.controller;

import com.grocerylist.core.service.IngredientService;
import com.grocerylist.core.service.ProductService;
import com.grocerylist.mapper.IngredientMapper;
import com.grocerylist.mapper.ProductMapper;
import com.grocerylist.model.Ingredient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ingredient")
@RequiredArgsConstructor
public class IngredientController {

    private IngredientMapper ingredientMapper;
    private IngredientService ingredientService;

    public IngredientController(IngredientMapper ingredientMapper, IngredientService ingredientService) {
        this.ingredientMapper = ingredientMapper;
        this.ingredientService = ingredientService;


    }
}
