package com.example.noservendingmachine.exception;

public class DependencyFailedException extends RuntimeException {

    public DependencyFailedException(final String message) {
        super(message);
    }
}
