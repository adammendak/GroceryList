package com.grocerylist.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserType {
    ADMIN("admin"),
    USER("user");

    private String value;
}
