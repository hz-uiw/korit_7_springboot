package com.korit.springboot_study.exception;

public class CustomNullPointerException extends NullPointerException {



    public CustomNullPointerException(String message) {
        super(message);
    }
}
