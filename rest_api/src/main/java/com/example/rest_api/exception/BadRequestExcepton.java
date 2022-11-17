package com.example.rest_api.exception;

public class BadRequestExcepton extends RuntimeException {
    public  BadRequestExcepton(String message){
        super(message);
    }
}
