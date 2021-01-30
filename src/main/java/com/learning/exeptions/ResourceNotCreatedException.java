package com.learning.exeptions;

public class ResourceNotCreatedException extends RuntimeException {
    public ResourceNotCreatedException(String message) {
        super(message);
    }
}
