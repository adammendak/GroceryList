package com.grocerylist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class LoginData {
    //TODO DELETE, use model module
    private String userName;
    private String hashPassword;
}
