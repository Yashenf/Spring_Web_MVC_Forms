package com.example.demo.util.ecxeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntryNotFoundException extends RuntimeException {
    public EntryNotFoundException(String msg){
        super(msg);
    }
}
