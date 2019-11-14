package com.grocerylist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.grocerylist.constants.UserType;
import lombok.Data;

@Data
public class UserDto {

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("userType")
    private UserType userType;
}
