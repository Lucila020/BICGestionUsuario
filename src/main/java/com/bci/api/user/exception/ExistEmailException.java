package com.bci.api.user.exception;

import com.bci.api.user.dto.ErrorDTO;

public class ExistEmailException extends RuntimeException {

    public ExistEmailException(final ErrorDTO errorDTO) {

        super(errorDTO.getMessage());
    }
}
