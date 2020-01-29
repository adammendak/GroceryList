package com.grocerylist.repository;

import com.grocerylist.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
/**
 * @author  Adam Mendak
 * @version 1.0
 * @since   2019-12-03
 *
 * This interface consists exclusively of method which used for data transmission in ProductCategoryService.class from core module
 *  This interface is a description of the actions that Product Category can do
 * @return ProductCategory type of optional
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    Optional<ProductCategory> findByName(String name);
}
