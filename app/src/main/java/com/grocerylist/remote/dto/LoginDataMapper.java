package com.grocerylist.remote.dto;

import com.grocerylist.model.LoginData;

//@Mapper??
public class LoginDataMapper {
    public LoginData mapToLoginData(LoginDataDto loginDataDto) {
        //TODO: implements support of Hash
        LoginData loginData = new LoginData();
        loginData.setHashPassword("ByleCo");
        loginData.setUserName(loginDataDto.getUserName());
        return loginData;

        //return new LoginData(loginDataDto.getUserName(),"byleCo");


    }
}
