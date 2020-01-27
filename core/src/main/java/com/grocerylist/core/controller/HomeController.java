package com.grocerylist.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController()
public class HomeController {

    @GetMapping
    public String index() {
        return "Server works: " + LocalTime.now();
    }
}

