package com.grocerylist.core.exception;

public class UserExistException extends Throwable {
    public UserExistException(String message) {
        super(message);
    }
}