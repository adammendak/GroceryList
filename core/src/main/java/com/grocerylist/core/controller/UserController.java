package com.grocerylist.core.controller;

import com.grocerylist.core.service.UserService;
import com.grocerylist.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity getUser(@PathVariable Long id) {
        //todo Implement in dish service
        return null;
    }

    @GetMapping
    public ResponseEntity getAllUsers() {
        //todo Implement in dish service
        return null;
    }

    @PostMapping
    public ResponseEntity createUser(@Valid @RequestBody UserDto userDto) {
        //todo Implement in dish service
        return null;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateUser(@Valid @RequestBody UserDto userDto) {
        //todo Implement
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        //todo Implement
        return null;
    }
}
