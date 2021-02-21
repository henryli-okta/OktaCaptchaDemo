package com.example.demo.okta.captcha.services.providers;

import com.example.demo.okta.captcha.beans.instances.CaptchaInstance;

public abstract class CaptchaProviderImpl implements CaptchaProvider {
    private CaptchaInstance captchaInstance;

    public CaptchaInstance getCaptchaInstance() {
        return captchaInstance;
    }

    @Override
    public void setCaptchaInstance(CaptchaInstance captchaInstance) {
        this.captchaInstance = captchaInstance;
    }
}
