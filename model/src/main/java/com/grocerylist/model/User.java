package com.grocerylist.model;

import lombok.Data;

import javax.persistence.*;
/**
 * @author  Adam Mendak
 * @version 1.0
 * @since   2019-10-19
 *
 * Abstract class which contains fields for holding entered user data
 */
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

    @Column(name = "PASSWORD", nullable = false)
    private String password;

}
