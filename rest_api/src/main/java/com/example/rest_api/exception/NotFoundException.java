package com.example.rest_api.exception;

public class NotFoundException  extends  RuntimeException{
    public  NotFoundException(String masage){
        super(masage);
    }
}
