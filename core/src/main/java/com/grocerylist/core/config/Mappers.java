package com.grocerylist.core.config;

import com.grocerylist.mapper.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mappers {

    @Bean
    public DishCategoryMapper dishCategoryMapper() {
        return new DishCategoryMapperImpl();
    }

    @Bean
    public DishMapper dishMapper() {
        return new DishMapperImpl();
    }

    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }

    @Bean
    public IngredientMapper ingredientMapper() {
        return new IngredientMapperImpl();
    }

    @Bean
    public ProductMapper productMapper() {
        return new ProductMapperImpl();
    }

    @Bean
    public ProductCategoryMapper productCategoryMapper() {
        return new ProductCategoryMapperImpl();
    }
}
