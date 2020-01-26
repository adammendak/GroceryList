package com.grocerylist.core.service;

import com.grocerylist.constants.Unit;
import com.grocerylist.core.exception.ResourceNotFoundException;
import com.grocerylist.dto.ProductDto;
import com.grocerylist.mapper.ProductMapper;
import com.grocerylist.model.Product;
import com.grocerylist.model.ProductCategory;
import com.grocerylist.repository.ProductCategoryRepository;
import com.grocerylist.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductMapper productMapper;

    public ProductDto findById(Long id) throws ResourceNotFoundException {
        return productRepository.findById(id)
                .map(productMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Product Not Found"));
    }

    public List<ProductDto> findByProductCategory(String name) {
        return productRepository.findByProductCategory_Name(name)
                .stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    public Product findByName(String name) {
        return productRepository.findByName(name).orElse(null);
    }

    public List<ProductDto> findAll() {
        return productRepository
                .findAll()
                .stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProductDto save(@Valid ProductDto productDto) throws ResourceNotFoundException {

        Product product = new Product();
        product.setName(productDto.getName());
        Optional<ProductCategory> productCategory =
                productCategoryRepository.findByName(productDto.getProductCategory().getName());

        product.setProductCategory(productCategory
                .orElseThrow(()->new ResourceNotFoundException("Product Category not found!")));

        product.setUnit(Unit.valueOf(productDto.getUnit()));
        productRepository.save(product);
        return productMapper.toDto(product);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product update(@Valid ProductDto productDto, Long id) throws ResourceNotFoundException {
        Optional<Product> entity = productRepository.findById(id);
        if(!entity.isPresent()) {
            throw new ResourceNotFoundException("Product Not Found");
        }
        Optional<ProductCategory> productCategory =
                productCategoryRepository.findByName(productDto.getProductCategory().getName());

        Product product = entity.get();
        product.setName(productDto.getName());
        product.setProductCategory(productCategory
                .orElseThrow(()->new ResourceNotFoundException("Product Category not found!")));
        product.setUnit(Unit.valueOf(productDto.getUnit()));
        return productRepository.save(product);
    }

    public void delete(Long id) throws ResourceNotFoundException {
        Product entity = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product Not Found"));
        productRepository.delete(entity);
    }
}
