package com.cinesage.user_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(UserNotFoundException.class)
   public ResponseEntity<String> handleUserNotFound(UserNotFoundException e){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
   }

   @ExceptionHandler(MovieNotFoundException.class)
   public ResponseEntity<String> handleUserNotFound(MovieNotFoundException e){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
   }

   @ExceptionHandler(Exception.class)
   public ResponseEntity<String> handleUserNotFound(Exception e){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
   }

}
