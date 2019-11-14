package com.grocerylist.mapper;

import com.grocerylist.dto.UserDto;
import com.grocerylist.model.Admin;

import com.grocerylist.model.Client;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    Admin toEntityAdmin(UserDto dto);
    UserDto toUserDto(Admin entity);

    Client toEntityUser(UserDto dto);
    UserDto toDto(Client entity);
}
