package com.grocerylist.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * The GroceryList is an application that
 * prepare GroceryList for chosen dishes.
 *
 * @author  Adam Mendak
 * @version 1.0
 * @since   2019-10-06
 */

@SpringBootApplication
@EntityScan(basePackages = "com.grocerylist.model")
@EnableJpaRepositories(basePackages = "com.grocerylist.repository")
public class CoreApplication {
    /**
     * This is the main method which makes use of run method.
     * @param args
     * @return Nothing.
     */
    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }

}
