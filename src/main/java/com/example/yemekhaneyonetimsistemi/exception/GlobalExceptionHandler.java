package com.example.yemekhaneyonetimsistemi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<ErrorDetails>handleResourceNotFoundException(ResourceNotFoundException exception,WebRequest request){

ErrorDetails details=new ErrorDetails(
  HttpStatus.NOT_FOUND.value(),
  exception.getMessage()
);
return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
   }

}
