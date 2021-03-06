package com.grocerylist.core.service;

import com.grocerylist.core.exception.ResourceNotFoundException;
import com.grocerylist.dto.DishDto;
import com.grocerylist.model.Dish;
import com.grocerylist.model.DishCategory;
import com.grocerylist.model.Ingredient;
import com.grocerylist.repository.DishCategoryRepository;
import com.grocerylist.repository.DishRepository;
import com.grocerylist.mapper.DishMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * @author  Adam Mendak
 * @version 1.0
 * @since   2019-10-20
 *
 *  This class is for executes the operation on the database
 *
 */
@Service
@RequiredArgsConstructor
public class DishService {

    private final DishRepository dishRepository;
    private final DishMapper dishMapper;
    private final DishCategoryRepository dishCategoryRepository;
    private final IngredientService ingredientService;
    private final ProductService productService;

    public DishDto findById(Long id) throws ResourceNotFoundException {
        return dishRepository.findById(id)
                .map(dishMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Product Not Found"));
    }

    public List<DishDto> findAll() {
        return dishRepository
                .findAll()
                .stream()
                .map(dishMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<DishDto> findByDishCategory(String name) {
        return dishRepository.findByCategories_Name(name)
                .stream()
                .map(dishMapper::toDto)
                .collect(Collectors.toList());
    }

    public DishDto save(@Valid DishDto dto) throws ResourceNotFoundException {
        Dish dish = dishMapper.toEntity(dto);
        Dish saved = persistDish(dto, dish);
        return dishMapper.toDto(saved);
    }

    public Dish save(Dish dish) {
        return dishRepository.save(dish);
    }

    public DishDto update(@Valid DishDto dto, Long id) throws ResourceNotFoundException {
        Optional<Dish> entity = dishRepository.findById(id);
        if(!entity.isPresent()) {
            throw new ResourceNotFoundException("Dish Not Found");
        }
        Dish dish = entity.get();
        Dish saved = persistDish(dto, dish);
        return dishMapper.toDto(saved);
    }

    public void delete(Long id) throws ResourceNotFoundException {
        Dish entity = dishRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dish Not Found"));
        dishRepository.delete(entity);
    }

    private Dish persistDish(@Valid DishDto dto, Dish dish) {
        List<DishCategory> dishCategories = dto.getCategories().stream()
                .map(x -> dishCategoryRepository.findByName(x.getName()).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        if(!CollectionUtils.isEmpty(dto.getIngredients())) {
            List<Ingredient> ingredients = dto.getIngredients().stream()
                    .map(x -> {
                        Ingredient ingredient = new Ingredient();
                        ingredient.setQuantity(x.getQuantity());
                        ingredient.setProduct(productService.findByName(x.getProduct().getName()));
                        return ingredient;
                    })
                    .collect(Collectors.toList());
            ingredients.forEach(ingredientService::save);
            dish.setIngredients(ingredients);
        }

        dish.setCategories(dishCategories);
        dish.setDescription(dto.getDescription());
        dish.setDifficultyLevel(dto.getDifficultyLevel());
        dish.setNumberOfServings(dto.getNumberOfServings());
        dish.setPrepareTime(dto.getPrepareTime());

        return dishRepository.save(dish);
    }
    
}
