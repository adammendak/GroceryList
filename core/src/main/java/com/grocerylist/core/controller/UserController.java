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
/**
 * @author  Elżbieta Dutkiewicz
 * @version 1.0
 * @since   2020-01-15
 * This class contains methods for users database
 */
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    /**
     * getUser() method accepts the request for GET
     *
     * @param id
     * @return ResponseEntity
     * @throws UserNotExistException
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity getUser(@PathVariable Long id) throws UserNotExistException {
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userDto);
    }
    /**
     * loginUser() method accepts the request for POST
     *
     * @param userDto
     * @return ResponseEntity
     */
    @PostMapping(value = "/login")
    public ResponseEntity loginUser(@Valid @RequestBody UserDto userDto) throws UserNotExistException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.findUserByUserNameAndPassword(userDto));
    }
    /**
     * getAllUsers() method accepts the request for GET
     *
     * @return ResponseEntity
     */
    @GetMapping
    public ResponseEntity getAllUsers() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.findAll());
         }
    /**
     * createUser() method accepts the request for POST
     *
     * @param userDto
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity createUser(@Valid @RequestBody UserDto userDto) throws UserExistException {
        UserDto createdUser =userService.createUser(userDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdUser);
    }
    /**
     * updateUser() method accepts the request for PUT
     *
     * @param userDto
     * @return ResponseEntity
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity updateUser(@Valid @RequestBody UserDto userDto, @PathVariable  Long id) throws UserNotExistException {
        userService.updateUser(userDto, id);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("user is updated");
    }
    /**
     * updateUser() method accepts the request for DELETE
     *
     * @param id
     * @return ResponseEntity
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) throws UserNotExistException {
        userService.deleteUser(id);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("user was removed");
    }
}
