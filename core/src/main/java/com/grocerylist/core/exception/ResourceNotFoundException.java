package com.grocerylist.core.exception;
/**
 * @author  Adam Mendak
 * @version 1.0
 * @since   2019-12-03
 *
 *  This class invoke method to inform about ResourceNotFoundException
 *  @extends Throwable
 */
public class ResourceNotFoundException extends Throwable {

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
