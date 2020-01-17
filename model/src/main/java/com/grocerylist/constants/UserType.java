package com.grocerylist.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserType {
    ADMIN("admin"),
    CLIENT("client");

    private String value;
}
