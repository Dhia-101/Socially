package com.dhia.springsocialmediaapi.controllers;

import com.dhia.springsocialmediaapi.services.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


//    @ExceptionHandler({MethodArgumentNotValidException.class})
//    public ResponseEntity<Object> handleArgumentNotValid(Exception exception, WebRequest request) {
//        return new ResponseEntity<Object>(exception.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
//    }


    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(Exception exception) {
        return new ResponseEntity<Object>(exception.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        System.out.println(ex.getFieldErrors("publisherId"));
//        for (ObjectError error : ex.getBindingResult().getFieldErrors()) {
//            System.out.println(error.getObjectName() + ": " + error.getDefaultMessage());
//        }
        return new ResponseEntity<Object>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);    }
}
