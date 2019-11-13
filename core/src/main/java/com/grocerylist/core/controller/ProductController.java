package com.grocerylist.core.controller;

import com.grocerylist.core.service.ProductService;
import com.grocerylist.mapper.ProductMapper;
import com.grocerylist.model.Product;
import com.grocerylist.dto.ProductDto;
//import com.grocerylist.dto.ProductMapper;
//import com.grocerylist.usecase.GetProductsUseCase;
//import com.grocerylist.usecase.ProcessProductUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(value = "/api/v1", produces = APPLICATION_JSON_VALUE)
public class ProductController {



    //TODO remove getProductsUseCase , use ProductService from core/services

    private ProductMapper productMapper;
    private ProductService productService;


    public ProductController(ProductMapper productMapper, ProductService productService) {
        this.productMapper = productMapper;
        this.productService = productService;


    }

    @PostMapping("/add-product")
    public ResponseEntity<String> addProduct(@RequestBody ProductDto productDto) {
        if (Objects.isNull(productDto.getName())) {

            return new ResponseEntity("Your request body is not correct", HttpStatus.BAD_REQUEST);
        }
        Product product = productMapper.mapToProduct(productDto);
//        product = processProductUseCase.addProduct(product);
        return new ResponseEntity("Your product was added", HttpStatus.CREATED);


    }

    @DeleteMapping("/remove-product")
    public ResponseEntity<String> removeProduct(@RequestParam Long id) {
        if (Objects.isNull(id)) {

            return new ResponseEntity("Your request body is not correct", HttpStatus.BAD_REQUEST);
        }
        boolean isRemoved = true;// = processProductUseCase.removeProduct(id);
        return isRemoved ? new ResponseEntity("Your Product was removed", HttpStatus.CREATED) :
                new ResponseEntity("Something goes wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/get-products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> productsList =null; //getProductsUseCase.getAllProducts();
        return ResponseEntity.status(HttpStatus.CREATED).body(productsList);
//        return new ResponseEntity(productsList, HttpStatus.CREATED);
    }


}
