package com.grocerylist.core.repository;

import com.grocerylist.constants.Unit;
import com.grocerylist.model.*;

import java.util.List;

public interface Repository {

    //todo implement in different classes in spring data interface with querydsl impl

    List<Dish> getDishes();
    List<Ingredient> getIngredients();
    List<User> getUsers();
    List<ProductCategory> getProductCategories();
    List<DishCategory> getDishCategories();
    List<Product> getProducts();
    List<Unit> getUnits();


    void add(Dish dish);
    void add(Ingredient ingredient);
    void add(User user);
    void add(ProductCategory productCategory);
    void add(DishCategory dishCategory);
    void add(Product product);
    void add(Unit unit);


    void update(Dish dish);
    void update(Ingredient ingredient);
    void update(User user);
    void update(ProductCategory productCategory);
    void update(DishCategory dishCategory);
    void update(Product product);
    void update(Unit unit);


    void remove(Dish dish);
    void remove(Ingredient ingredient);
    void remove(User user);
    void remove(ProductCategory productCategory);
    void remove(DishCategory dishCategory);
    void remove(Product product);
    void remove(Unit unit);


    User getByCredentials(String login, String password);

}
