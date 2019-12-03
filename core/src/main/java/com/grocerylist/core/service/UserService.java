package com.grocerylist.core.service;

import com.grocerylist.repository.AdminRepository;
import com.grocerylist.repository.ClientRepository;
import com.grocerylist.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final AdminRepository adminRepository;
    private final ClientRepository clientRepository;
    private final UserMapper userMapper;

}
