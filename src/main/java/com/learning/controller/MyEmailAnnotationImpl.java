package com.learning.controller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyEmailAnnotationImpl implements ConstraintValidator<MyEmail, String> {

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return email.contains("@");
    }
}