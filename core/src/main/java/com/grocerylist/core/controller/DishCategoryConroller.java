package com.grocerylist.core.controller;

import com.grocerylist.core.service.DishCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dishCategory")
@RequiredArgsConstructor
public class DishCategoryConroller {

    private final DishCategoryService dishCategoryService;
}
