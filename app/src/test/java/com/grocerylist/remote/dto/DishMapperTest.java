package com.grocerylist.remote.dto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DishMapperTest {

    @Test
    void mapToDish() {
        List<String> list = new ArrayList<>();
        list.add("Milk");
        list.add("Potato");
        list.add("Water");
        list.forEach(System.out::println);
    }
}