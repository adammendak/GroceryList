package com.grocerylist.core.service;

import com.grocerylist.repository.ProductRepository;
import com.grocerylist.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

}
