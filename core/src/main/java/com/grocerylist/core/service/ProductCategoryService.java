package com.grocerylist.core.service;

import com.grocerylist.dto.ProductCategoryDto;
import com.grocerylist.mapper.ProductCategoryMapper;
import com.grocerylist.model.ProductCategory;
import com.grocerylist.repository.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;
    private final ProductCategoryMapper mapper;

    public ProductCategoryDto save(ProductCategoryDto dto) {
        productCategoryRepository.save(mapper.toEntity(dto));
        return dto;
    }

    public ProductCategory save(ProductCategory dto) {
        return productCategoryRepository.save(dto);
    }

}
