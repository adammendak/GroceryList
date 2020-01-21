package com.grocerylist.core.service;

import com.grocerylist.core.exception.UserExistException;
import com.grocerylist.core.exception.UserNotExistException;
import com.grocerylist.dto.UserDto;
import com.grocerylist.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class UserServiceTest {

    UserService userService;
    UserRepository userRepository;


    @Before
    public void init() {

        MockitoAnnotations.initMocks(this);
        userService = mock(UserService.class);
        userRepository = mock(UserRepository.class);

    }

    @Test
    public void findUserByUserNameAndPassword() throws UserNotExistException {

        UserDto expected = new UserDto(1L, "testName", "test@mail.com", "testPassword");
        given(userService
                .findUserByUserNameAndPassword(expected))
                .willReturn(new UserDto(1L, "testName", "test@mail.com", "testPassword"));
        UserDto actual = userService.findUserByUserNameAndPassword(expected);
        assertThat(actual, is(equalTo(expected)));

    }

    @Test(expected = UserNotExistException.class)
    public void shouldThrowExceptionCauseUserNotExistException() throws UserNotExistException {

        UserDto expected = new UserDto(1L, "testName", "test@mail.com", "testPassword");
        given(userService
                .findUserByUserNameAndPassword(expected))
                .willThrow(UserNotExistException.class);
        userService.findUserByUserNameAndPassword(expected);

    }

    @Test
    public void createUser() throws UserExistException {

        UserDto expected = new UserDto(1L, "testName", "test@mail.com", "testPassword");
        given(userService
                .createUser(expected))
                .willReturn(new UserDto(1L, "testName", "test@mail.com", "testPassword"));
        UserDto actual = userService.createUser(expected);
        assertThat(actual, is(equalTo(expected)));

    }


    @Test
    public void getUserById() throws UserNotExistException {

        UserDto expected = new UserDto(1L, "testName", "test@mail.com", "testPassword");
        given(userService
                .getUserById(1L))
                .willReturn(new UserDto(1L, "testName", "test@mail.com", "testPassword"));
        UserDto actual = userService.getUserById(1L);
        assertThat(actual, is(equalTo(expected)));

    }

    @Test
    public void findAll() throws UserNotExistException {

        List<UserDto> expected = Arrays.asList(new UserDto(1L, "testName", "test@mail.com", "testPassword")
                , new UserDto(2L, "test2Name", "test2@mail.com", "test2Password"));
        given(userService
                .findAll())
                .willReturn(Arrays.asList(new UserDto(1L, "testName", "test@mail.com", "testPassword")
                        , new UserDto(2L, "test2Name", "test2@mail.com", "test2Password")));
        List<UserDto> actual = userService.findAll();
        assertThat(actual, is(equalTo(expected)));

    }

}