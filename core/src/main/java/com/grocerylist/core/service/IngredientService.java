package com.grocerylist.core.service;

import com.grocerylist.core.exception.ResourceNotFoundException;
import com.grocerylist.dto.IngredientDto;
import com.grocerylist.model.Ingredient;
import com.grocerylist.repository.IngredientRepository;
import com.grocerylist.mapper.IngredientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;

    public IngredientDto findById(Long id) throws ResourceNotFoundException {
        return ingredientRepository.findById(id)
                .map(ingredientMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Ingredient Not Found"));
    }

    public IngredientDto save(@Valid IngredientDto ingredientDto) {
        ingredientRepository.save(ingredientMapper.toEntity(ingredientDto));
        return ingredientDto;
    }

    public Ingredient save(@Valid Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public void delete(Long id) throws ResourceNotFoundException {
        Ingredient entity = ingredientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ingredient Not Found"));
        ingredientRepository.delete(entity);
    }
}

