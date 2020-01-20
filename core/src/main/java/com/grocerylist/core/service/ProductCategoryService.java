package com.grocerylist.core.service;

import com.grocerylist.core.exception.ResourceNotFoundException;
import com.grocerylist.dto.ProductCategoryDto;
import com.grocerylist.mapper.ProductCategoryMapper;
import com.grocerylist.model.ProductCategory;
import com.grocerylist.repository.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;
    private final ProductCategoryMapper productCategoryMapper;

    public ProductCategoryDto findById(Long id) throws ResourceNotFoundException {
        return productCategoryRepository.findById(id)
                .map(productCategoryMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Product Not Found"));
    }

    public ProductCategory findByName(String name) {
        return productCategoryRepository.findByName(name).orElse(null);
    }

    public List<ProductCategoryDto> findAll() {
        return productCategoryRepository
                .findAll()
                .stream()
                .map(productCategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProductCategoryDto save(@Valid ProductCategoryDto productCategoryDto) {
        ProductCategory productCategory = productCategoryMapper.toEntity(productCategoryDto);
        productCategoryRepository.save(productCategory);
        return productCategoryMapper.toDto(productCategory);
    }

    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    public ProductCategory update(@Valid ProductCategoryDto productCategoryDto, Long id) {

        Optional<ProductCategory> entity = productCategoryRepository.findById(id);
        ProductCategory productCategory = entity.get();
        productCategory.setId(productCategoryDto.getId());
        productCategory.setName(productCategoryDto.getName());

        return productCategoryRepository.save(productCategory);
    }

    public void delete(Long id) throws ResourceNotFoundException {
        ProductCategory entity = productCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProductCategory Not Found"));
        productCategoryRepository.delete(entity);
    }
}
