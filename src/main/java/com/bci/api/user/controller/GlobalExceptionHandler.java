package com.bci.api.user.controller;

import com.bci.api.user.exception.ExistEmailException;
import com.bci.api.user.exception.IllegalArgumentException;
import com.bci.api.user.exception.InActiveUserException;
import com.bci.api.user.exception.UnauthorizedAccessException;
import com.bci.api.user.exception.UserNotFoundException;
import com.bci.api.user.exception.ValidateFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String MESSAGE = "{\"mensaje\": \"";

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        String errorMessage = MESSAGE + "Ocurrió un error inesperado.\"}";
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ValidateFormatException.class)
    public ResponseEntity<String> handleCustomException(ValidateFormatException ex) {
        String errorMessage = MESSAGE + ex.getMessage() + "\"}";
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExistEmailException.class)
    public ResponseEntity<String> handleEmailException(ExistEmailException ex) {
        String errorMessage = MESSAGE + ex.getMessage() + "\"}";
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        String errorMessage = MESSAGE + ex.getMessage() + "\"}";
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedAccessException.class)
    public ResponseEntity<String> handleUnhathorizedAccessException(UnauthorizedAccessException ex) {
        String errorMessage = MESSAGE + ex.getMessage() + "\"}";
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
        String errorMessage = MESSAGE + ex.getMessage() + "\"}";
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InActiveUserException.class)
    public ResponseEntity<String> handleInActiveUserException(InActiveUserException ex) {
        String errorMessage = MESSAGE + ex.getMessage() + "\"}";
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}

