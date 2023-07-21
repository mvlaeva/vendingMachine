package com.example.noservendingmachine.exception;

public class MaximumCapacityExceededException extends RuntimeException {

    public MaximumCapacityExceededException(final String message) {
        super(message);
    }
}
