package com.csi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RecordNotFoundExeption extends RuntimeException{
   public RecordNotFoundExeption(String msg){
        super(msg);
    }
}
