package com.grocerylist.repository;

import com.grocerylist.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);

    List<Product> findByProductCategory_Name(String productCategory);

    Optional<Product> findById(Long id);
}
