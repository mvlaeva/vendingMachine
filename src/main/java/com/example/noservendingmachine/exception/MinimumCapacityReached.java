package com.example.noservendingmachine.exception;

public class MinimumCapacityReached extends RuntimeException {

    public MinimumCapacityReached(final String message) {
        super(message);
    }
}
