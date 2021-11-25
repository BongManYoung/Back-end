package com.hackathon.MYD.model.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class ResponseData<T> extends Response {
    private T data;


    public ResponseData(HttpStatus status, String message, T data) {
        super(status, message);
        this.data = data;
    }
}
