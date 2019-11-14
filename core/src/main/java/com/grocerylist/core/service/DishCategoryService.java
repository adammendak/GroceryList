package com.grocerylist.core.service;

import com.grocerylist.dao.repository.DishCategoryRepository;
import com.grocerylist.mapper.DishCategoryMapper;
import com.grocerylist.mapper.DishCategoryMapperImpl;
import com.grocerylist.model.Dish;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DishCategoryService {

    private final DishCategoryRepository dishCategoryRepository;
    private final DishCategoryMapper dishCategoryMapper = new DishCategoryMapperImpl();

}
