package com.grocerylist.core.bootstrap;

import com.grocerylist.core.service.DishCategoryService;
import com.grocerylist.model.DishCategory;
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

    @Override
    public void run(String... args) throws Exception {
        log.info("####Adding base data to dev database");
        log.info("####Adding DishCategory");

        DishCategory dishCatPasta = new DishCategory();
        dishCatPasta.setName("Pasta");
        dishCategoryService.save(dishCatPasta);

        DishCategory dishCatVege = new DishCategory();
        dishCatVege.setName("Wegetarian");
        dishCategoryService.save(dishCatVege);
    }
}
