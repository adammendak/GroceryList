package com.grocerylist.core.bootstrap;

import com.google.common.collect.Lists;
import com.grocerylist.constants.Unit;
import com.grocerylist.core.exception.UserExistException;
import com.grocerylist.core.service.*;
import com.grocerylist.dto.UserDto;
import com.grocerylist.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
/**
 * @author  Adam Mendak
 * @version 1.0
 * @since   2019-12-03
 * This class implements CommandLineRunner.interface, it loads dummy data if dev profile
 * is set.
 */
@Profile("dev")
@Slf4j
@RequiredArgsConstructor
@Component
public class DevDataBootstrap implements CommandLineRunner {

    private final DishCategoryService dishCategoryService;
    private final ProductService productService;
    private final ProductCategoryService productCategoryService;
    private final IngredientService ingredientService;
    private final DishService dishService;
    private final UserService userService;

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
        diavola.setPrepareTime(60);
        diavola.setDifficultyLevel("Medium");
        diavola.setNumberOfServings(2);
        diavola.setIngredients(Lists.newArrayList(salamiIngredient));
        diavola.setCategories(Lists.newArrayList(dishCatPizza));
        dishService.save(diavola);

        Dish tomatoPasta = new Dish();
        tomatoPasta.setDescription("Tomato Pasta");
        tomatoPasta.setDifficultyLevel("Easy");
        tomatoPasta.setPrepareTime(30);
        tomatoPasta.setNumberOfServings(2);
        tomatoPasta.setIngredients(Lists.newArrayList(tomatoIngredient));
        tomatoPasta.setCategories(Lists.newArrayList(dishCatPasta));
        dishService.save(tomatoPasta);

        UserDto testClient = new UserDto();
        testClient.setUserName("test");
        testClient.setPassword("test");
        testClient.setEmail("test@test.pl");

        try {
            userService.createUser(testClient);
        } catch (UserExistException e) {
            e.printStackTrace();
        }
        log.info("####Adding test users");
    }
}
