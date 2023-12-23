package com.bci.api.user.exception;


public class ValidateFormatException  extends RuntimeException {

    private final String message;

    public ValidateFormatException(final String message) {
        this.message = message;

    }

    @Override
    public String getMessage() {
        return message;
    }
}
