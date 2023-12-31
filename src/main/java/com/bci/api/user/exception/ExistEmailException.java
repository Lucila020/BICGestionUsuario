package com.bci.api.user.exception;


public class ExistEmailException extends RuntimeException {

    private final String message;

    public ExistEmailException(final String message) {
        this.message = message;

    }

    @Override
    public String getMessage() {
        return message;
    }
}
