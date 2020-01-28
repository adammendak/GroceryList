package com.grocerylist.core.exception;
/**
 * @author  Elżbieta Dutkiewicz
 * @version 1.0
 * @since   2019-12-06
 *
 * This class invoke method to inform about UserExistException
 * @extends Throwable
 */
public class UserExistException extends Throwable {
    public UserExistException(String message) {
        super(message);
    }
}
