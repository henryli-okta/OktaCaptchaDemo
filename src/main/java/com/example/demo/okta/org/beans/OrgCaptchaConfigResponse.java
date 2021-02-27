package com.example.demo.okta.org.beans;

import com.example.demo.okta.captcha.beans.instances.CaptchaInstance;

import java.util.List;

public class OrgCaptchaConfigResponse {

    private List<String> enabledPages;
    private CaptchaInstance captchaInstance;

    public List<String> getEnabledPages() {
        return enabledPages;
    }

    public void setEnabledPages(List<String> enabledPages) {
        this.enabledPages = enabledPages;
    }

    public CaptchaInstance getCaptchaInstance() {
        return captchaInstance;
    }

    public void setCaptchaInstance(CaptchaInstance captchaInstance) {
        this.captchaInstance = captchaInstance;
    }
}
