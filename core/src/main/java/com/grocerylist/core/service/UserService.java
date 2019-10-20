package com.grocerylist.core.service;

import com.grocerylist.dao.repository.AdminRepository;
import com.grocerylist.dao.repository.ClientRepository;
import com.grocerylist.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final AdminRepository adminRepository;
    private final ClientRepository clientRepository;

    public UserDto login(String login, String password) {
        //todo implement
        return null;
    }

}
