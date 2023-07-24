package com.example.noservendingmachine.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BusinessLogicException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleBusinessLogicException(final BusinessLogicException ex) {
        LOGGER.error(ex.getMessage(), ex);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(DependencyFailedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleDependencyFailedException(final DependencyFailedException ex) {
        LOGGER.error(ex.getMessage(), ex);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(MaximumCapacityExceededException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleMaximumCapacityExceededException(final MaximumCapacityExceededException ex) {
        LOGGER.error(ex.getMessage(), ex);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(MinimumCapacityReached.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleMinimumCapacityReached(final MinimumCapacityReached ex) {
        LOGGER.error(ex.getMessage(), ex);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}