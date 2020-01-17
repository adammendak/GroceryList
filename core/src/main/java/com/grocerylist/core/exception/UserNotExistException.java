package com.grocerylist.core.exception;

public class UserNotExistException extends Throwable {
    public UserNotExistException(String message) {
        super(message);
    }
}
