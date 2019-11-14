package com.grocerylist.core.service;

import com.grocerylist.dao.repository.IngredientRepository;
import com.grocerylist.mapper.IngredientMapper;
import com.grocerylist.mapper.IngredientMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper = new IngredientMapperImpl();
}

