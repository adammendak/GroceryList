package com.grocerylist.core.exception;
/**
 * @author  Elżbieta Dutkiewicz
 * @version 1.0
 * @since   2019-12-06
 *
 * This class invoke method to inform about UserNotExistException
 * @extends Throwable
 */
public class UserNotExistException extends Throwable {
    public UserNotExistException(String message) {
        super(message);
    }
}
