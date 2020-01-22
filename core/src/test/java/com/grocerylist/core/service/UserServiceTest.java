package com.grocerylist.core.service;

import com.grocerylist.core.exception.UserExistException;
import com.grocerylist.core.exception.UserNotExistException;
import com.grocerylist.dto.UserDto;
import com.grocerylist.mapper.UserMapper;
import com.grocerylist.model.Client;
import com.grocerylist.repository.ClientRepository;
import com.grocerylist.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    UserService userService;
    UserRepository userRepository;
    ClientRepository clientRepository;
    UserMapper userMapper;


    @Before
    public void init() {

        MockitoAnnotations.initMocks(this);
        userRepository = mock(UserRepository.class);
        clientRepository = mock(ClientRepository.class);
        userMapper = mock(UserMapper.class);
        userService = new UserService(userRepository, clientRepository, userMapper);

    }

    @Test
    public void findUserByUserNameAndPassword() throws UserNotExistException {
//        given
        String userName = "testName";
        String password = "testPassword";
        String email = "test@gmail.com";
        UserDto expected = new UserDto(1L, userName, email, password);

        Client client = new Client();
        client.setId(1L);
        client.setUserName(userName);
        client.setEmail(email);
        client.setPassword(password);

        given(clientRepository
                .findByUserNameAndPassword(userName, password))
                .willReturn(Optional.of(client));
        given(userMapper.toDto(any(Client.class)))
                .willReturn(expected);
//        when
        UserDto actual = userService.findUserByUserNameAndPassword(expected);
//        then
        assertThat(actual, is(equalTo(expected)));

    }

    @Test(expected = UserNotExistException.class)
    public void shouldThrowExceptionCauseUserNotExistException() throws UserNotExistException {

        String userName = "testName";
        String password = "testPassword";
        String email = "test@gmail.com";
        UserDto expected = new UserDto(1L, userName, email, password);

        given(clientRepository
                .findByUserNameAndPassword(userName, password))
                .willReturn(Optional.empty());

//        when
        userService.findUserByUserNameAndPassword(expected);

    }


    @Test
    public void createUser() throws UserExistException {
//       given
        String userName = "testName";
        String password = "testPassword";
        String email = "test@gmail.com";
        UserDto expected = new UserDto(1L, userName, email, password);

        Client client = new Client();
        client.setId(1L);
        client.setUserName(userName);
        client.setEmail(email);
        client.setPassword(password);


        given(clientRepository
                .findByEmail(email))
                .willReturn(null);
        given(clientRepository
                .findByUserName(userName))
                .willReturn(null);
        given(userMapper.toEntityUser(any(UserDto.class)))
                .willReturn(client);
        given(clientRepository.save(any(Client.class)))
                .willReturn(client);
        given(userMapper.toDto(any(Client.class)))
                .willReturn(new UserDto(1L, userName, email, password));

//        when
        UserDto actual = userService.createUser(new UserDto(null, userName, email, password));
//        then
        assertThat(actual, is(equalTo(expected)));

    }

    //TODO: to implements
    @Test
    public void getUserById() throws UserNotExistException {


    }

    //TODO: to implements
    @Test
    public void findAll() throws UserNotExistException {


    }

    //
    @Test
    public void deleteUser() throws UserNotExistException {

//        given
        String userName = "testName";
        String password = "testPassword";
        String email = "test@gmail.com";

        Client client = new Client();
        client.setId(1L);
        client.setUserName(userName);
        client.setEmail(email);
        client.setPassword(password);

        given(userRepository.findById(1L))
                .willReturn(Optional.of(client));


//        when
        userService.deleteUser(1L);

//        then
        verify(userRepository).delete(client);

    }

    @Test
    public void updateUser() throws UserNotExistException {

//        given
        Long id = 1L;
        String userName = "testName";
        String password = "testPassword";
        String email = "test@gmail.com";

        Client client = new Client();
        client.setId(id);
        client.setUserName(userName);
        client.setEmail(email);
        client.setPassword(password);

        UserDto expected = new UserDto(id, "test2Name", email, password);

        given(clientRepository
                .findById(id))
                .willReturn(Optional.of(client));

        given(clientRepository.save(any(Client.class)))
                .willReturn(client);

        given(userMapper.toDto(any(Client.class)))
                .willReturn(new UserDto(id, "test2Name", email, password));
//        when
        UserDto userDto = userService.updateUser(expected, id);

//        then
        assertThat(userDto, is(equalTo(expected)));

    }


}