package com.grocerylist.core.service;

import com.grocerylist.dao.repository.DishCategoryRepository;
import com.grocerylist.dto.DishCategoryDto;
import com.grocerylist.mapper.DishCategoryMapper;
import com.grocerylist.mapper.DishCategoryMapperImpl;
import com.grocerylist.model.DishCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DishCategoryService {

    private final DishCategoryRepository dishCategoryRepository;
    private final DishCategoryMapper dishCategoryMapper = new DishCategoryMapperImpl();

    public DishCategoryDto findById(Long id) {
        Optional<DishCategory> dishCategoryOptional = dishCategoryRepository.findById(id);
        //TODO: add support of null/ add exception
        return dishCategoryOptional
                .map(dishCategoryMapper::toDto)
                .orElse(null);
    }

    public List<DishCategoryDto> findAll() {
        return dishCategoryRepository
                .findAll()
                .stream()
                .map(dishCategoryMapper::toDto)
                .collect(Collectors.toList());

    }

}
