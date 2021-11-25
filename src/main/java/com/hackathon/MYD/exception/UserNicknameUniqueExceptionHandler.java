package com.hackathon.MYD.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class UserNicknameUniqueExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    protected ExceptionResponse userAlreadyExistsExceptionHandler(final DataIntegrityViolationException e){
        final String message = e.getMessage();
        return new ExceptionResponse(409,message);
    }
}
