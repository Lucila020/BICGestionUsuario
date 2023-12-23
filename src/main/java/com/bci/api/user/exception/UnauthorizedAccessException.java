package com.bci.api.user.exception;


public class UnauthorizedAccessException extends RuntimeException {

    private final String message;

    public UnauthorizedAccessException(final String message) {
        this.message = message;

    }

    @Override
    public String getMessage() {
        return message;
    }
}
