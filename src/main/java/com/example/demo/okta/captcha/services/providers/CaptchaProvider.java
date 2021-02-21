package com.example.demo.okta.captcha.services.providers;

import com.example.demo.okta.captcha.beans.CaptchaType;
import com.example.demo.okta.captcha.beans.CaptchaVerifyResponse;
import com.example.demo.okta.captcha.beans.instances.CaptchaInstance;

public interface CaptchaProvider {
    CaptchaType getType();
    CaptchaVerifyResponse checkCaptchaVerifyResult(String token);
    void setCaptchaInstance(CaptchaInstance captchaInstance);
}
