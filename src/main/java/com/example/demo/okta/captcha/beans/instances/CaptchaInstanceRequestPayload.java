package com.example.demo.okta.captcha.beans.instances;

import com.example.demo.okta.captcha.beans.CaptchaType;
import com.example.demo.okta.captcha.views.Views;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

public class CaptchaInstanceRequestPayload {

    @JsonView(Views.PublicView.class)
    @JsonProperty(required = true)
    private String name;

    @JsonView(Views.PublicView.class)
    @JsonProperty(value = "sitekey", required = true)
    private String siteKey;

    @JsonProperty(required = true)
    private String secretKey;

    @JsonView(Views.PublicView.class)
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
