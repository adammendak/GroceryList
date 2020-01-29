package com.grocerylist.repository;

import com.grocerylist.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
/**
 * @author  Adam Mendak
 * @version 1.0
 * @since   2019-10-19
 *
 * This interface consists exclusively of methods used for data transmission in ProductService.class from core module
 * This interface is a description of the actions that Product Category can do
 * @return Product type of objects and lists
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);

    List<Product> findByProductCategory_Name(String productCategory);

    Optional<Product> findById(Long id);
}
