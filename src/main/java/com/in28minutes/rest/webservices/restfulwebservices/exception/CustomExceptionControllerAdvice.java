package com.in28minutes.rest.webservices.restfulwebservices.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomExceptionControllerAdvice  extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {

        CustomExceptionResponse customExceptionResponse =
                new CustomExceptionResponse(new Date(), ex.getMessage(),
                        request.getDescription(false));
       return new ResponseEntity<>(customExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) {

        CustomExceptionResponse customExceptionResponse =
                new CustomExceptionResponse(new Date(), ex.getMessage(),
                        request.getDescription(false));
        return new ResponseEntity<>(customExceptionResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        CustomExceptionResponse customExceptionResponse =
                new CustomExceptionResponse(new Date(), "Validation Fail",
                        ex.getLocalizedMessage().toString());
        return new ResponseEntity<>(customExceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
