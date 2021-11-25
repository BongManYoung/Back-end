package com.hackathon.MYD.exception;

public class StoreNotFoundException extends BasicException{
    public StoreNotFoundException() {
        super(ExceptionMessage.STORE_NOT_FOUND);
    }
}
