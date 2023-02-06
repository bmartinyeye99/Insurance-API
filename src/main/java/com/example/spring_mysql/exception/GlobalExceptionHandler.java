package com.example.spring_mysql.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//If we want to specify the response status of
//a controller method,
//we can mark that method with @ResponseStatus.

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, org.springframework.http.HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String,Object>body = new HashMap<>();
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(x->x.getDefaultMessage()).collect(Collectors.toList());

        body.put("errors",errors);
        return new ResponseEntity<>(body,headers,status);


    }
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException exception){
//        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation error", exception.getBindingResult().
//                getFieldError().getDefaultMessage());
//    return new  ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
//    }



}
