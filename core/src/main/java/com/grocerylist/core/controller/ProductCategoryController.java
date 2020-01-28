package com.grocerylist.core.controller;

import com.grocerylist.core.exception.ResourceNotFoundException;
import com.grocerylist.core.service.ProductCategoryService;
import com.grocerylist.dto.ProductCategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
/**
 * @author Elżbieta Dutkiewicz
 * @version 1.0
 * @since 2020-01-17
 * This class contains methods for manage product categories database
 */
@RestController
@RequestMapping("/api/productCategory")
@RequiredArgsConstructor
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;
    /**
     * getProductCategory() method accepts the request for GET
     *
     * @param id
     * @return ResponseEntity
     * @throws ResourceNotFoundException
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity getProductCategory(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productCategoryService.findById(id));
    }
    /**
     * getAllProductCategories() method accepts the request for GET
     *
     * @return ResponseEntity
     */
    @GetMapping
    public ResponseEntity getAllProductCategories() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productCategoryService.findAll());
    }
    /**
     * createProductCategory() method accepts the request for POST
     *
     * @param productCategoryDto
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity createProductCategory(@Valid @RequestBody ProductCategoryDto productCategoryDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productCategoryService.save(productCategoryDto));
    }
    /**
     * updateProductCategory() method accepts the request for PUT
     *
     * @param productCategoryDto
     * @param id
     * @return ResponseEntity
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity updateProductCategory(@Valid @RequestBody ProductCategoryDto productCategoryDto, @PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productCategoryService.update(productCategoryDto, id));
    }
    /**
     * deleteProductCategory() method accepts the request for DELETE
     *
     * @param id
     * @throws ResourceNotFoundException
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteProductCategory(@PathVariable Long id) throws ResourceNotFoundException {
        productCategoryService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("ProductCategory Deleted");
    }
}

