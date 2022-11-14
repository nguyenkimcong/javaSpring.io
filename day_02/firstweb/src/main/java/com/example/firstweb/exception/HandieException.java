package com.example.firstweb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandieException {
    // Xử lý badrequest
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleBadRequestException(BadRequestException exception) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    // xử lý notfound
    @ExceptionHandler(NotFoundExcepiton.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handlNotFOUNDException(NotFoundExcepiton exception) {
        return new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
    }


    // xử lý các loại còn lại
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleotherException(Exception exception) {
        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
    }
}
