package com.grocerylist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.grocerylist.constants.UserType;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("userName")
    @NotNull
    private String userName;

    @JsonProperty("email")
    @NotNull
    private String email;

    @JsonProperty("password")
    @NotNull
    private String password;

    @JsonProperty("userType")
    private UserType userType;
}
