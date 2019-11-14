package com.grocerylist.core.controller;

import com.grocerylist.core.service.ProductService;
import com.grocerylist.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/{id}")
    public ResponseEntity getProduct(@PathVariable Long id) {
        //todo Implement in dish service
        return null;
    }

    @GetMapping
    public ResponseEntity getAllProducts() {
        //todo Implement in dish service
        return null;
    }

    @PostMapping
    public ResponseEntity createProduct(@Valid @RequestBody ProductDto productDto) {
        //todo Implement in dish service
        return null;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateProduct(@Valid @RequestBody ProductDto productDto) {
        //todo Implement
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        //todo Implement
        return null;
    }
}
