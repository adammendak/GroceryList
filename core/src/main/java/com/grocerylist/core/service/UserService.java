package com.grocerylist.core.service;

import com.grocerylist.core.exception.UserExistException;
import com.grocerylist.dto.UserDto;
import com.grocerylist.model.Client;
import com.grocerylist.model.User;
import com.grocerylist.repository.AdminRepository;
import com.grocerylist.repository.ClientRepository;
import com.grocerylist.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final AdminRepository adminRepository;
    private final ClientRepository clientRepository;
    private final UserMapper userMapper;

    public UserDto createUser(UserDto userDto) throws UserExistException {
        User user = clientRepository.findByEmail(userDto.getEmail());
        if (Objects.nonNull(user)) {
            throw new UserExistException("There is already a user with that Email");
        }

        user = clientRepository.findByUserName(userDto.getUserName());
        if (Objects.nonNull(user)) {
            throw new UserExistException("There is already a user with that Name");
        }
        Client client = userMapper.toEntityUser(userDto);
        client.setPasswordHash("byleco");
        client = clientRepository.save(client);


        return userMapper.toDto(client);

    }


}
