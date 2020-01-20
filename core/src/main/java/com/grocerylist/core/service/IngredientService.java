package com.grocerylist.core.service;

import com.grocerylist.core.controller.ProductController;
import com.grocerylist.core.exception.ResourceNotFoundException;
import com.grocerylist.dto.IngredientDto;
import com.grocerylist.mapper.IngredientMapper;
import com.grocerylist.model.Ingredient;
import com.grocerylist.model.Product;
import com.grocerylist.repository.IngredientRepository;
import com.grocerylist.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;
    private ProductRepository productRepository;
    private ProductController productDto;
    private Product product;

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

    public List<IngredientDto> findAll() {
        return ingredientRepository
                .findAll()
                .stream()
                .map(ingredientMapper::toDto)
                .collect(Collectors.toList());
    }

    public IngredientDto update(@Valid IngredientDto ingredientDto, Long id) throws ResourceNotFoundException {
        Optional<Ingredient> entity = ingredientRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ResourceNotFoundException("Ingredient Not Found");
        }

        Ingredient ingredient = entity.get();
        Ingredient saved = persistIngredient(ingredientDto, ingredient);
        return ingredientMapper.toDto(saved);
    }

    private Ingredient persistIngredient(@Valid IngredientDto ingredientDto, Ingredient ingredient) {

        ingredient.setQuantity(ingredientDto.getQuantity());
        ingredient.setProduct(product);

        return ingredientRepository.save(ingredient);
    }
}


