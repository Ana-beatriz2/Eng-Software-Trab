package com.example.SoftwareLocacao.services.exceptions;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class DataIntegrityViolationException extends DataAccessException {
    public DataIntegrityViolationException(String message) {
        super(message);
    }
}
