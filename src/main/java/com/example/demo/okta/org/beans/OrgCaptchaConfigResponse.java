package com.example.demo.okta.org.beans;

import com.example.demo.okta.captcha.beans.instances.CaptchaInstance;

public class OrgCaptchaConfigResponse {

    private Boolean enabled;
    private CaptchaInstance captchaInstance;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public CaptchaInstance getCaptchaInstance() {
        return captchaInstance;
    }

    public void setCaptchaInstance(CaptchaInstance captchaInstance) {
        this.captchaInstance = captchaInstance;
    }
}
