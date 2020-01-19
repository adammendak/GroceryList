package com.grocerylist.core.service;

import com.grocerylist.core.exception.UserExistException;
import com.grocerylist.core.exception.UserNotExistException;
import com.grocerylist.dto.UserDto;
import com.grocerylist.mapper.UserMapper;
import com.grocerylist.model.Client;
import com.grocerylist.model.User;
import com.grocerylist.repository.ClientRepository;
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
    private final ClientRepository clientRepository;
    private final UserMapper userMapper;

    public UserDto findUserByUserNameAndPassword(UserDto userDto) throws UserNotExistException{
        Optional<Client> fromDb =clientRepository
                .findByUserNameAndPassword(userDto.getUserName(), userDto.getPassword());

        if(fromDb.isPresent()){
            return userMapper.toDto(fromDb.get());
        } else {
            throw new UserNotExistException("No such user in database");
        }
    }

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
        client.setPassword(userDto.getPassword());
        client.setUserName(userDto.getUserName());
        client.setEmail(userDto.getEmail());
        client = clientRepository.save(client);

        return userMapper.toDto(client);
    }

    public UserDto updateUser(UserDto userDto, Long id) throws UserNotExistException {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (!clientOptional.isPresent()) {
            throw new UserNotExistException("There isn't any user with given Id");
        }

        Client client = clientOptional.get();
        client.setEmail(userDto.getEmail());
        client.setPassword(userDto.getPassword());
        client.setUserName(userDto.getUserName());
        return userMapper.toDto(clientRepository.save(client));
    }

    public UserDto getUserById(Long id) throws UserNotExistException {
        Optional<Client> user = clientRepository.findById(id);
        if (user.isPresent()) {
            return user.map(userMapper::toDto).get();
        } else {
            throw new UserNotExistException("User don't exist in Database");
        }
    }

    public List<UserDto> findAll() {
        return clientRepository
                .findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteUser(Long id) throws UserNotExistException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotExistException("User Not Found"));
        userRepository.delete(user);

    }

}
