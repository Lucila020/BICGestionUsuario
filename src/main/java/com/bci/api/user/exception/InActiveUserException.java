package com.bci.api.user.exception;


public class InActiveUserException extends RuntimeException {

    private final String message;

    public InActiveUserException(final String message) {
        this.message = message;

    }

    @Override
    public String getMessage() {
        return message;
    }
}
