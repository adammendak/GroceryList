package com.grocerylist.core.service;

import com.grocerylist.core.exception.ResourceNotFoundException;
import com.grocerylist.dao.repository.DishCategoryRepository;
import com.grocerylist.dto.DishCategoryDto;
import com.grocerylist.mapper.DishCategoryMapper;
import com.grocerylist.model.DishCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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

    public DishCategoryDto save(@Valid DishCategory dishCategory) {
        DishCategory dishCatSaved = dishCategoryRepository.save(dishCategory);
        return dishCategoryMapper.toDto(dishCatSaved);
    }

}
