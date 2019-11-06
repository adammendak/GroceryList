package com.grocerylist.remote.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class LoginDataDto {
    //TODO move to MODEL/dto module
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("password")
    private String password;
    @JsonProperty("retriedPassword")
    private String retriedPassword;
}
