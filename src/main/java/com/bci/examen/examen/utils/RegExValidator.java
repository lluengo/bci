package com.bci.examen.examen.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExValidator {

    private final static String EMAIL_RE = "^(.+)@(.+)$";
    private final static String PASSWORD_RE = "^(?=.*[a-z])(?=.*[A-Z]{1})(?=.*\\d)[A-Za-z\\d@$!%*?&]{8,12}$";

    public static boolean validateEmail(String email){
        Pattern pattern = Pattern.compile(EMAIL_RE);
        return pattern.matcher(email).matches();
    }

    public static boolean validatePassword(String password){
        Pattern pattern = Pattern.compile(PASSWORD_RE);
        return pattern.matcher(password).matches();
    }


}
