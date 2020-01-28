package com.grocerylist.core.controller;

import com.grocerylist.core.exception.ResourceNotFoundException;
import com.grocerylist.core.service.ProductService;
import com.grocerylist.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Adam Mendak
 * @version 1.0
 * @since 2019-11-14
 * This class contains methods for manage products database
 */
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /**
     * getProduct() method accepts the request for GET
     *
     * @param id
     * @return ResponseEntity
     * @throws ResourceNotFoundException
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity getProduct(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.findById(id));
    }

    /**
     * getProductsForName() method accepts the request for GET
     *
     * @param name
     * @return ResponseEntity
     * @throws ResourceNotFoundException
     */
    @GetMapping(value = "/getByName/{name}")
    public ResponseEntity getProductsForName(@PathVariable String name) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.findByProductCategory(name));
    }

    /**
     * getAllProducts() method accepts the request for GET
     *
     * @return ResponseEntity
     */
    @GetMapping
    public ResponseEntity getAllProducts() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.findAll());
    }

    /**
     * createProduct() method accepts the request for POST
     *
     * @param productDto
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity createProduct(@Valid @RequestBody ProductDto productDto) throws ResourceNotFoundException {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.save(productDto));
    }

    /**
     * updateProduct(() method accepts the request for PUT
     *
     * @param productDto
     * @param id
     * @return ResponseEntity
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity updateProduct(@Valid @RequestBody ProductDto productDto, @PathVariable Long id)
            throws ResourceNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.update(productDto, id));
    }

    /**
     * deleteProduct() method accepts the request for DELETE
     *
     * @param id
     * @throws ResourceNotFoundException
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) throws ResourceNotFoundException {
        productService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Product Deleted");
    }
}
