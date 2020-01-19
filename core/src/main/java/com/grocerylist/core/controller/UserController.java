package com.grocerylist.core.controller;

import com.grocerylist.core.exception.UserExistException;
import com.grocerylist.core.exception.UserNotExistException;
import com.grocerylist.core.service.UserService;
import com.grocerylist.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity getUser(@PathVariable Long id) throws UserNotExistException {
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userDto);
    }

    @PostMapping(value = "/login")
    public ResponseEntity loginUser(@Valid @RequestBody UserDto userDto) throws UserNotExistException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.findUserByUserNameAndPassword(userDto));
    }

    @GetMapping
    public ResponseEntity getAllUsers() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.findAll());
         }

    @PostMapping
    public ResponseEntity createUser(@Valid @RequestBody UserDto userDto) throws UserExistException {
        UserDto createdUser =userService.createUser(userDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdUser);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateUser(@Valid @RequestBody UserDto userDto, @PathVariable  Long id) throws UserNotExistException {
        userService.updateUser(userDto, id);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("user is updated");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) throws UserNotExistException {
        userService.deleteUser(id);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("user was removed");
    }
}
