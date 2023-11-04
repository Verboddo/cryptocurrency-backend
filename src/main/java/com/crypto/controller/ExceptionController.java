package com.crypto.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.crypto.exceptions.CryptocurrencyNotFoundException;

@RestController
@ControllerAdvice
public class ExceptionController {
    
    
    /** 
     * @param exception
     * @return ResponseEntity<Object>
     */
    @ExceptionHandler
    public ResponseEntity<Object> exception(CryptocurrencyNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exception.getMessage());
    }
}
