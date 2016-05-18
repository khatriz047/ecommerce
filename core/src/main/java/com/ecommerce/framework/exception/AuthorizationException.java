package com.ecommerce.framework.exception;

/**
 * Created by Admin on 5/18/2016.
 */
public class AuthorizationException extends Exception {
    public AuthorizationException() {
    }

    public AuthorizationException(String message) {
        super(message);
    }

    public AuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }
}
