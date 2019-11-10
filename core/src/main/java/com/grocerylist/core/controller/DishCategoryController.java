package com.grocerylist.core.controller;

import com.grocerylist.core.service.DishCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dishCategory")
@RequiredArgsConstructor
public class DishCategoryController {

    private final DishCategoryService dishCategoryService;
}
