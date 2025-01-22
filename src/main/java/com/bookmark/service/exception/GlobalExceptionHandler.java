package com.bookmark.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException(Exception ex)
    {
        ErrorMessage errorMessage=new ErrorMessage();
        errorMessage.setError(ex.fillInStackTrace().toString());
        errorMessage.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return  new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(NoBookMarkFoundException.class)
    public ResponseEntity<ErrorMessage> handleNoBookMarkFoundException(NoBookMarkFoundException ex)
    {
        ErrorMessage errorMessage=new ErrorMessage();
        errorMessage.setError(ex.getMessage());
        errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
        return  new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
    }
}
