package com.grocerylist.mapper;

import com.grocerylist.dto.UserDto;
import com.grocerylist.model.Admin;

import com.grocerylist.model.Client;
import com.grocerylist.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    Admin toEntityAdmin(UserDto dto);

    UserDto toDto(Admin entity);

    Client toEntityUser(UserDto dto);

    UserDto toDto(Client entity);

    UserDto toDto(User user);
}
