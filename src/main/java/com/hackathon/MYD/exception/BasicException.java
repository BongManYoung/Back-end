package com.hackathon.MYD.exception;

import lombok.Getter;

@Getter
public class BasicException extends RuntimeException{
    private final ExceptionMessage exceptionMessage;

    public BasicException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());

        this.exceptionMessage = exceptionMessage;
    }
}
