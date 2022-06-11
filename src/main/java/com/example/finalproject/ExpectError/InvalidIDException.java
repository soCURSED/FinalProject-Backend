package com.example.finalproject.ExpectError;

public class InvalidIDException extends RuntimeException {
    public InvalidIDException(String message) {
        super(message);
    }
}