package com.grocerylist.dao.repository;

import com.grocerylist.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
