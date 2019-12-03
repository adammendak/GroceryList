package com.grocerylist.core.service;

import com.grocerylist.core.exception.ResourceNotFoundException;
import com.grocerylist.dto.DishCategoryDto;
import com.grocerylist.mapper.DishCategoryMapper;
import com.grocerylist.model.DishCategory;
import com.grocerylist.repository.DishCategoryRepository;
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

    public DishCategoryDto save(@Valid DishCategoryDto dishCategoryDto) {
        DishCategory dishCatSaved = dishCategoryRepository.save(dishCategoryMapper.toEntity(dishCategoryDto));
        return dishCategoryMapper.toDto(dishCatSaved);
    }

}
