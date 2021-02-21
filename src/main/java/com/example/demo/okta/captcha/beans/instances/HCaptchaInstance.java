package com.example.demo.okta.captcha.beans.instances;

import com.example.demo.okta.captcha.beans.CaptchaType;

public class HCaptchaInstance extends CaptchaInstance {
    @Override
    public CaptchaType getType() {
        return CaptchaType.HCAPTCHA;
    }

    public HCaptchaInstance() {
        setScriptUrl("https://hcaptcha.com/1/api.js?onload=onloadCallback&render=explicit");
        setVerifyUrl("https://hcaptcha.com/siteverify");
        setRenderScript("function onloadCallback() {\n" +
                "                console.log(\"onloadCallback\");\n" +
                "                hcaptcha.render('myBtn', {\n" +
                "                   'sitekey' : captchaConfigResponse.sitekey,\n" +
                "                   'callback' : verifyCaptchaChallenge\n" +
                "                });\n" +
                "            }");
    }
}
