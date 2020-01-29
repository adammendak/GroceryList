package com.grocerylist.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author  Elżbieta Dutkiewicz
 * @version 1.0
 * @since   2020-01-19
 *
 * This class is for next application to serve static html files, deprecated for now
 *
 */
@SpringBootApplication
public class FrontendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrontendApplication.class, args);
    }

}
