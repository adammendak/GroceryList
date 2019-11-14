package com.grocerylist.core.service;

import com.grocerylist.dao.repository.DishRepository;
import com.grocerylist.mapper.DishCategoryMapper;
import com.grocerylist.mapper.DishCategoryMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DishService {

    private final DishRepository dishRepository;
    private final DishCategoryMapper dishCategoryMapper = new DishCategoryMapperImpl();
}
