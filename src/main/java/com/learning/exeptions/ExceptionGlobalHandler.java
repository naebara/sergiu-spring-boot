package com.learning.exeptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionGlobalHandler {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionGlobalHandler.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExeptionResponse> handlePersonNotFoundException(ResourceNotFoundException exception) {
        ExeptionResponse er = new ExeptionResponse();
        er.setMessage(exception.getMessage());
        er.setTime(LocalDateTime.now());
        er.setErrorCode("NOT FOUND");

        logger.error(exception.getMessage(), exception);
        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }

}
