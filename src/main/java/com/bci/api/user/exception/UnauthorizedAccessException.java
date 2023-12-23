package com.bci.api.user.exception;

import com.bci.api.user.dto.ErrorDTO;

public class UnauthorizedAccessException extends RuntimeException {

    public UnauthorizedAccessException(ErrorDTO error) {

        super(String.valueOf(error));
    }
}
