package com.bci.api.user.validator;

import com.bci.api.user.exception.ExistEmailException;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EmailValidator {

    private static final String EMAIL_REGEX ="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.cl";

    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public void validateEmail(String email) {
        Matcher matcher = pattern.matcher(email);
            if (!matcher.matches())
                throw new ExistEmailException("Email invalido");
        }

}

