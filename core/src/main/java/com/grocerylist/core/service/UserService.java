package com.grocerylist.core.service;

import com.grocerylist.dao.repository.AdminRepository;
import com.grocerylist.dao.repository.ClientRepository;
import com.grocerylist.dto.UserDto;
import com.grocerylist.mapper.UserMapper;
import com.grocerylist.mapper.UserMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final AdminRepository adminRepository;
    private final ClientRepository clientRepository;

    private final UserMapper userMapper = new UserMapperImpl();

}
