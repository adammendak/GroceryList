package com.grocerylist.model;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "LOGIN", nullable = false)
    private String login;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PASSWORD_HASH", nullable = false)
    private String passwordHash;

    // TODO: zaimplementować

    public static User tryLogin(String login, String password) {
        throw new UnsupportedOperationException();
    }
}
