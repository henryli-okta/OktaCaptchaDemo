package com.example.demo.okta.captcha.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CaptchaVerifyResponse {
    @JsonProperty(required = true)
    private boolean success;

    private String challenge_ts;

    private String hostname;

    @JsonProperty(value = "error-codes")
    private List<String> errorCodes;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getChallenge_ts() {
        return challenge_ts;
    }

    public void setChallenge_ts(String challenge_ts) {
        this.challenge_ts = challenge_ts;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public List<String> getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(List<String> errorCodes) {
        this.errorCodes = errorCodes;
    }

    @Override
    public String toString() {
        return "CaptchaVerifyResponse{" +
                "success='" + success + '\'' +
                ", challenge_ts='" + challenge_ts + '\'' +
                ", hostname='" + hostname + '\'' +
                ", errorCodes=" + errorCodes +
                '}';
    }
}
