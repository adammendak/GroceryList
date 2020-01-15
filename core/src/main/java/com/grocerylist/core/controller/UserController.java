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
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity getUser(@PathVariable Long id) {
        Optional<UserDto> userDto = userService.getUserById(id);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userDto.isPresent() ? userDto : "user don't exist in Database");


    }

    @GetMapping
    public ResponseEntity getAllUsers() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.findAll());
         }

    @PostMapping
    public ResponseEntity createUser(@Valid @RequestBody UserDto userDto) throws UserExistException {
        userService.createUser(userDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("user is added");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateUser(@Valid @RequestBody UserDto userDto, @PathVariable  Long id) throws UserNotExistException {
        userService.updateUser(userDto, id);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("user is updated");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        //todo Implement
        return null;
    }
}
