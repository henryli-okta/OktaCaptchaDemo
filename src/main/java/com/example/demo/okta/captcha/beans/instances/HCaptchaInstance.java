package com.example.demo.okta.captcha.beans.instances;

import com.example.demo.okta.captcha.beans.CaptchaType;

public class HCaptchaInstance extends CaptchaInstance {
    @Override
    public CaptchaType getType() {
        return CaptchaType.HCAPTCHA;
    }
}
