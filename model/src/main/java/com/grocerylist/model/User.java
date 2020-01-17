package com.grocerylist.model;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class User extends AbstractTimestampableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USERNAME", nullable = false)
    private String userName;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PASSWORD_HASH", nullable = false)
    private String passwordHash;


}
