package com.bci.api.user.exception;

import com.bci.api.user.dto.ErrorDTO;

public class UserNotFoundException extends RuntimeException {


    public UserNotFoundException(final ErrorDTO error) {
        super(error.getMessage());
    }
}