package com.bci.api.user.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+cl";

    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public static boolean validateEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    public static void main(String[] args) {
        String[] emails = {"user@example.cl", "user@domain.cl", "invalid.email", "another@.com", "aaaaaa@domain.cl"};

        for (String email : emails) {
            System.out.println(email + " es válido: " + validateEmail(email));
        }
    }
}
