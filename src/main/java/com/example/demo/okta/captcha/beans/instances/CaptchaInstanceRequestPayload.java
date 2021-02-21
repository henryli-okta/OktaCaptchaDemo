package com.example.demo.okta.captcha.beans.instances;

import com.example.demo.okta.captcha.beans.CaptchaType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CaptchaInstanceRequestPayload {
    @JsonProperty(required = true)
    private String name;
    @JsonProperty(required = true)
    private String siteKey;
    @JsonProperty(required = true)
    private String secretKey;
    @JsonProperty(required = true)
    private CaptchaType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSiteKey() {
        return siteKey;
    }

    public void setSiteKey(String siteKey) {
        this.siteKey = siteKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public CaptchaType getType() {
        return type;
    }

    public void setType(CaptchaType type) {
        this.type = type;
    }
}
