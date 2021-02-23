package com.example.demo.okta.captcha.services.providers;

import com.example.demo.okta.captcha.beans.instances.CaptchaInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public abstract class CaptchaProviderImpl implements CaptchaProvider {
    private CaptchaInstance captchaInstance;

    @Autowired
    protected RestTemplate restTemplate;

    public CaptchaInstance getCaptchaInstance() {
        return captchaInstance;
    }

    @Override
    public void setCaptchaInstance(CaptchaInstance captchaInstance) {
        this.captchaInstance = captchaInstance;
    }
}
