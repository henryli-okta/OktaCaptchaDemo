package com.example.demo.okta.exceptions;

public class CaptchaInstanceNotFoundException extends RuntimeException {
    public CaptchaInstanceNotFoundException(String message) {
        super(message);
    }
}
