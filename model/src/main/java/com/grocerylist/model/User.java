package com.grocerylist.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String email;
    private String passwordHash;

    // TODO: zaimplementować

    public static User tryLogin(String login, String password) {
        throw new UnsupportedOperationException();
    }
}
