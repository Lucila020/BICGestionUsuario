package com.bci.api.user.validator;

import com.bci.api.user.exception.ValidateFormatException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidator {

    private final String formatPassword;
    private final String formatPasswordMessage;

    public PasswordValidator(@Value("${api.format.password}") String formatPassword,
                             @Value("${api.format.password.message}") String formatPasswordMessage) {
        this.formatPassword = formatPassword;
        this.formatPasswordMessage = formatPasswordMessage;
    }

    public void validatePasswordFormat(String password) {
        if (!password.matches(formatPassword))
            throw new ValidateFormatException(formatPasswordMessage);
    }

}

