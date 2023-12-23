package com.bci.api.user.exception;

import com.bci.api.user.dto.ErrorDTO;

public class InActiveUserException extends RuntimeException {

    public InActiveUserException(final ErrorDTO errorDTO)
    {
        super(errorDTO.getMessage());
    }
}
