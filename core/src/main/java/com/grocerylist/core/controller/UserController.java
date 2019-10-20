package com.grocerylist.core.controller;

import com.grocerylist.core.service.UserService;
import com.grocerylist.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> login() {
        //todo implement
        UserDto userDto = userService.login("dummy", "dummy");
        return ResponseEntity.ok().body(userDto);
    }


}
