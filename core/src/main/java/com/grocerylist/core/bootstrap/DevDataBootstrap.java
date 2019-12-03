package com.grocerylist.core.bootstrap;

import com.google.common.collect.Lists;
import com.grocerylist.constants.Unit;
import com.grocerylist.core.service.*;
import com.grocerylist.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile(value = "dev")
@Slf4j
@RequiredArgsConstructor
@Component
public class DevDataBootstrap implements CommandLineRunner {

    private final DishCategoryService dishCategoryService;
    private final ProductService productService;
    private final ProductCategoryService productCategoryService;
    private final IngredientService ingredientService;
    private final DishService dishService;

    @Override
    public void run(String... args) {
        log.info("####Adding base data to dev database");
        log.info("####Adding DishCategory");

        DishCategory dishCatPasta = new DishCategory();
        dishCatPasta.setName("Pasta");
        dishCategoryService.save(dishCatPasta);

        DishCategory dishCatPizza = new DishCategory();
        dishCatPizza.setName("Pizza");
        dishCategoryService.save(dishCatPizza);

        log.info("####Adding ProductCategory");
        ProductCategory meatProdCat = new ProductCategory();
        meatProdCat.setName("Meat");
        productCategoryService.save(meatProdCat);

        ProductCategory vegetableProdCat = new ProductCategory();
        vegetableProdCat.setName("Vegetable");
        productCategoryService.save(vegetableProdCat);

        log.info("####Adding Product to database");
        Product tomato = new Product();
        tomato.setName("Tomato");
        tomato.setProductCategory(vegetableProdCat);
        tomato.setUnit(Unit.KG);
        productService.save(tomato);

        Product salami = new Product();
        salami.setName("Salami");
        salami.setProductCategory(meatProdCat);
        salami.setUnit(Unit.SLICE);
        productService.save(salami);

        log.info("####Adding Ingredients to database");
        Ingredient salamiIngredient = new Ingredient();
        salamiIngredient.setProduct(salami);
        salamiIngredient.setQuantity(10.0);
        ingredientService.save(salamiIngredient);

        Ingredient tomatoIngredient = new Ingredient();
        tomatoIngredient.setProduct(tomato);
        tomatoIngredient.setQuantity(20.0);
        ingredientService.save(tomatoIngredient);

        log.info("####Adding Dishes to database");
        Dish diavola = new Dish();
        diavola.setDescription("Pizza Diavola");
        diavola.setIngredients(Lists.newArrayList(salamiIngredient));
        diavola.setCategories(Lists.newArrayList(dishCatPizza));
        dishService.save(diavola);

        Dish tomatoPasta = new Dish();
        tomatoPasta.setDescription("Tomato Pasta");
        tomatoPasta.setIngredients(Lists.newArrayList(tomatoIngredient));
        tomatoPasta.setCategories(Lists.newArrayList(dishCatPasta));
        dishService.save(tomatoPasta);
    }
}
