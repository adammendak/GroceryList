package com.grocerylist.core.controller;

import com.grocerylist.core.exception.ResourceNotFoundException;
import com.grocerylist.core.service.ProductService;
import com.grocerylist.dto.ProductDenormalizedDto;
import com.grocerylist.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/{id}")
    public ResponseEntity getProduct(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.findById(id));
    }

    @GetMapping(value = "/getByName/{name}")
    public ResponseEntity getProductsForName(@PathVariable String name) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.findByProductCategory(name));
    }

    @GetMapping
    public ResponseEntity getAllProducts() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.findAll());
    }

    @PostMapping
    public ResponseEntity createProduct(@Valid @RequestBody ProductDenormalizedDto productDto) throws ResourceNotFoundException {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.save(productDto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateProduct(@Valid @RequestBody ProductDenormalizedDto productDto, @PathVariable Long id)
            throws ResourceNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.update(productDto, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) throws ResourceNotFoundException {
        productService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Product Deleted");
    }
}
