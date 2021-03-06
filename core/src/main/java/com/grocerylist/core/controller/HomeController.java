package com.grocerylist.core.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
/**
 * @author  Adam Mendak
 * @version 1.0
 * @since   2019-12-03
 * just a ping controller to check health status of application in production
 */
@RestController
@Profile(value = "prod")
public class HomeController {

    @GetMapping
    public String index() {
        return "Server works: " + LocalTime.now();
    }
}

