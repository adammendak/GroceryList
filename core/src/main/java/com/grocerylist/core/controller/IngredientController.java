package com.grocerylist.core.controller;

import com.grocerylist.core.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService ingredientService;
}
