package com.grocerylist.core.service;

import com.grocerylist.core.exception.ResourceNotFoundException;
import com.grocerylist.dto.DishCategoryDto;
import com.grocerylist.dto.ProductCategoryDto;
import com.grocerylist.mapper.DishCategoryMapper;
import com.grocerylist.model.DishCategory;
import com.grocerylist.model.ProductCategory;
import com.grocerylist.repository.DishCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * @author  Elżbieta Dutkiewicz
 * @version 1.0
 * @since   2019-11-17
 *
 * This class is for executes the operation on the database
 *
 */
@Service
@RequiredArgsConstructor
public class DishCategoryService {

    private final DishCategoryRepository dishCategoryRepository;
    private final DishCategoryMapper dishCategoryMapper;

    public DishCategoryDto findById(Long id) throws ResourceNotFoundException {
        return dishCategoryRepository.findById(id)
                .map(dishCategoryMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Dish Category Not Found"));
    }

    public List<DishCategoryDto> findAll() {
        return dishCategoryRepository
                .findAll()
                .stream()
                .map(dishCategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    public DishCategoryDto save(@Valid DishCategoryDto dishCategoryDto) {
        dishCategoryRepository.save(dishCategoryMapper.toEntity(dishCategoryDto));
        return dishCategoryDto;
    }

    public DishCategory update(@Valid DishCategoryDto categoryDto) {

        Optional<DishCategory> entity = dishCategoryRepository.findById(categoryDto.getId());
        DishCategory dishCategory = entity.get();
        dishCategory.setId(categoryDto.getId());
        dishCategory.setName(categoryDto.getName());

        return dishCategoryRepository.save(dishCategory);
    }

    public DishCategory save(DishCategory dishCategory) {
        return dishCategoryRepository.save(dishCategory);
    }

    public void delete(Long id) throws ResourceNotFoundException {
        DishCategory entity = dishCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dish Category Not Found"));
        dishCategoryRepository.delete(entity);
    }

}
