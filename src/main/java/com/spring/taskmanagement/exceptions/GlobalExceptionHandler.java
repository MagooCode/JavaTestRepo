package com.spring.taskmanagement.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ComponentScan
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> notValid(MethodArgumentNotValidException ex, HttpServletRequest request) {
        List<String> errors = new ArrayList<>();


        ex.getAllErrors().forEach(err -> errors.add(err.getDefaultMessage()));


        Map<String, Object> result = new HashMap<>();
        result.put("errors", errors);


        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

}
