package com.grocerylist.core.service;

import com.grocerylist.dao.repository.DishCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DishCategoryService {

    private final DishCategoryRepository dishCategoryRepository;
}