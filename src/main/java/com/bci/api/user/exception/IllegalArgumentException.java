package com.bci.api.user.exception;


public class IllegalArgumentException  extends RuntimeException {

    private final String message;

    public IllegalArgumentException(final String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
