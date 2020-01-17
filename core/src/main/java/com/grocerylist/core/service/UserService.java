package com.grocerylist.core.service;

import com.grocerylist.constants.UserType;
import com.grocerylist.core.exception.UserExistException;
import com.grocerylist.core.exception.UserNotExistException;
import com.grocerylist.dto.UserDto;
import com.grocerylist.model.Admin;
import com.grocerylist.model.Client;
import com.grocerylist.model.User;
import com.grocerylist.repository.AdminRepository;
import com.grocerylist.repository.ClientRepository;
import com.grocerylist.mapper.UserMapper;
import com.grocerylist.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
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
        client.setPasswordHash(userDto.getPassword());
        client = clientRepository.save(client);


        return userMapper.toDto(client);

    }

    public UserDto updateUser(UserDto userDto, Long id) throws UserNotExistException {

        if (userDto.getUserType().equals(UserType.CLIENT)) {
            Optional<Client> clientOptional = clientRepository.findById(id);
            if (!clientOptional.isPresent()) {
                throw new UserNotExistException("There isn't any user with given Id");
            }

            Client client = clientOptional.get();
            client.setEmail(userDto.getEmail());
            client.setPasswordHash(userDto.getPassword());
            client.setUserName(userDto.getUserName());
            clientRepository.save(client);
            return userMapper.toDto(client);
        } else {
            Optional<Admin> adminOptional = adminRepository.findById(id);
            if (!adminOptional.isPresent()) {
                throw new UserNotExistException("There isn't any user with given Id");
            }

            Admin admin = adminOptional.get();
            admin.setEmail(userDto.getEmail());
            admin.setPasswordHash(userDto.getPassword());
            admin.setUserName(userDto.getUserName());
            adminRepository.save(admin);
            return userMapper.toDto(admin);
        }
    }

    public Optional<UserDto> getUserById(Long id) {

        Optional<Client> user = clientRepository.findById(id);
        if (user.isPresent()) {
            UserDto userDto = user.map(userMapper::toDto).get();
            userDto.setUserType(UserType.CLIENT);
            return Optional.of(userDto);
        } else {
            return Optional.empty();
        }
    }

    public List<UserDto> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());

    }
}
