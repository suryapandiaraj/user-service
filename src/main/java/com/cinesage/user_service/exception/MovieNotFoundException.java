package com.cinesage.user_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException{

   public MovieNotFoundException(String message){
      super(message);
   }

   public MovieNotFoundException(String message, Throwable cause){
      super(message, cause);
   }
}
