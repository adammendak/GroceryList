package com.grocerylist.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
/**
 * @author  Adam Mendak
 * @version 1.0
 * @since   2019-12-03
 */
@RestController()
public class HomeController {

    @GetMapping
    public String index() {
        return "Server works: " + LocalTime.now();
    }
}

