package com.grocerylist.core.service;

import com.grocerylist.mapper.UserMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserService userService;
    private final UserMapperImpl userMapper = new UserMapperImpl();

}
