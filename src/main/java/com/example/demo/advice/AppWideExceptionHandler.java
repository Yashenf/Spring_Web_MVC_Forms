package com.example.demo.advice;

import com.example.demo.util.StandardResponse;
import com.example.demo.util.ecxeptions.EntryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(EntryNotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(EntryNotFoundException e){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        404,
                        e.getMessage()+" was occurred.",
                        e
                ), HttpStatus.NOT_FOUND
        );
    }
}
