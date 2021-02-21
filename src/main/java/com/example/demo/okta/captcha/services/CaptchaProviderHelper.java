package com.example.demo.okta.captcha.services;

import com.example.demo.okta.captcha.beans.instances.CaptchaInstance;
import com.example.demo.okta.captcha.services.providers.CaptchaProvider;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CaptchaProviderHelper {

    @Autowired
    private List<CaptchaProvider> captchaProviderList;

    public CaptchaProvider getCaptchaProvider(CaptchaInstance captchaInstance) {
        for (CaptchaProvider captchaProvider : captchaProviderList) {
            if (captchaProvider.getType().equals(captchaInstance.getType())) {
                return captchaProvider;
            }
        }
        throw new IllegalStateException("invalid CaptchaInstance");
    }
}
