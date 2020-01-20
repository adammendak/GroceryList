package com.grocerylist.core.controller;

import com.grocerylist.core.exception.ResourceNotFoundException;
import com.grocerylist.core.service.ProductCategoryService;
import com.grocerylist.dto.ProductCategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/productCategory")
@RequiredArgsConstructor
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @GetMapping(value = "/{id}")
    public ResponseEntity getProductCategory(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productCategoryService.findById(id));
    }

    @GetMapping
    public ResponseEntity getAllProductCategories() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productCategoryService.findAll());
    }

    @PostMapping
    public ResponseEntity createProductCategory(@Valid @RequestBody ProductCategoryDto productCategoryDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productCategoryService.save(productCategoryDto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateProductCategory(@Valid @RequestBody ProductCategoryDto productCategoryDto, @PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productCategoryService.update(productCategoryDto, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteProductCategory(@PathVariable Long id) throws ResourceNotFoundException {
        productCategoryService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("ProductCategory Deleted");
    }
}

