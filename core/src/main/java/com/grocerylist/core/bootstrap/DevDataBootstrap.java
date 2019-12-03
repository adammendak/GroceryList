package com.grocerylist.core.bootstrap;

import com.grocerylist.constants.Unit;
import com.grocerylist.core.service.DishCategoryService;
import com.grocerylist.core.service.ProductCategoryService;
import com.grocerylist.core.service.ProductService;
import com.grocerylist.dto.DishCategoryDto;
import com.grocerylist.dto.ProductCategoryDto;
import com.grocerylist.dto.ProductDto;
import com.grocerylist.model.Product;
import com.grocerylist.model.ProductCategory;
import com.grocerylist.repository.ProductCategoryRepository;
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

    @Override
    public void run(String... args) throws Exception {
        log.info("####Adding base data to dev database");
        log.info("####Adding DishCategory");

        DishCategoryDto dishCatPasta = new DishCategoryDto();
        dishCatPasta.setName("Pasta");
        dishCategoryService.save(dishCatPasta);

        DishCategoryDto dishCatPizza = new DishCategoryDto();
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
    }
}
