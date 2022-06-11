package com.example.finalproject.Advice;


import com.example.finalproject.DTO.API;
import com.example.finalproject.ExpectError.InvalidIDException;
import com.example.finalproject.ExpectError.NoProductExpectation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceHandler {
    @ExceptionHandler(InvalidIDException.class)
    public ResponseEntity InvalidIDException(InvalidIDException E) {
        String error = E.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(error, 400));
    }

    @ExceptionHandler(NoProductExpectation.class)
    public ResponseEntity NoFundsException(NoProductExpectation E) {
        String error = E.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(error, 400));
    }
}
