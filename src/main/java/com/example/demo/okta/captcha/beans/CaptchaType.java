package com.example.demo.okta.captcha.beans;

public enum CaptchaType {
    RECAPTCHAV2("recaptchav2_captcha", "ReCAPTCHA V2"),
    HCAPTCHA("hcaptcha_captcha", "hCAPTCHA");

    private final String appName;
    private final String displayName;

    CaptchaType(String appName, String displayName) {
        this.appName = appName;
        this.displayName = displayName;
    }

    public String getAppName() {
        return appName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
