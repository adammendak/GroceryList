package com.grocerylist.model;

import lombok.Data;

@Data
public abstract class User {
    private long id;
    private String login;
    private String email;
    private String passwordHash;

    // TODO: zaimplementować

    public static User tryLogin(String login, String password) {
        throw new UnsupportedOperationException();
    }
}
