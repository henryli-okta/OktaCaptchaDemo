package com.example.demo.okta.exceptions;

import org.springframework.http.HttpStatus;

/**
 * JsonObject used to return error playload to UI
 */
public class ApiError {

    private HttpStatus status;
    private String error;

    public ApiError() {
    }

    public ApiError(HttpStatus status, String error) {
        this.status = status;
        this.error = error;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}