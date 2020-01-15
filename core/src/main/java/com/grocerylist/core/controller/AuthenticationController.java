package com.grocerylist.core.controller;

import com.grocerylist.core.service.AuthenticationService;
import com.grocerylist.core.service.UserService;
import com.grocerylist.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/authenticate")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity authenticate(@Valid @RequestBody UserDto userDto) {
        //todo Implement in dish service
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(userService.getUserById(());//optional user dto
        return null;

    }
}
