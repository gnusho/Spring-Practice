package com.gnusho.practice.common.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler({SQLException.class, NoSuchAlgorithmException.class})
    public ResponseEntity<?> handleSQLException(SQLException e) {
        System.out.println(e.getMessage());
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({NullPointerException.class, IllegalArgumentException.class})
    public ResponseEntity<?> handleNPE(Exception e) {
        System.out.println(e.getMessage());
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public  ResponseEntity<?> duplicatedException(Exception e) {
        System.out.println(e.getMessage());
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

}
