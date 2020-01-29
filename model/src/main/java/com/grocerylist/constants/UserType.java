package com.grocerylist.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * @author  Adam Mendak
 * @version 1.0
 * @since   2019-10-19
 *
 * This class contains user type that can be used in database
 *
 */
@AllArgsConstructor
@Getter
public enum UserType {
    ADMIN("admin"),
    CLIENT("client");

    private String value;
}
