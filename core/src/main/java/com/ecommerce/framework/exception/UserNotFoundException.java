package com.ecommerce.framework.exception;

/**
 * Created by Admin on 5/18/2016.
 */
public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }

}
