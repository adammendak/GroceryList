package com.grocerylist.core.controller;

import com.grocerylist.core.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DishController {

    private final DishService dishService;
}