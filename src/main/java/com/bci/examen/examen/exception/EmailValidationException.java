package com.bci.examen.examen.exception;

import com.bci.examen.examen.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class EmailValidationException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public EmailValidationException(String email) {
        super("El email " + email + " no cumple con el formato esperado");
    }
}
