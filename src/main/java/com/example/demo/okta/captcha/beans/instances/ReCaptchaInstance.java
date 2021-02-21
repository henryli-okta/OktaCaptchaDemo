package com.example.demo.okta.captcha.beans.instances;

import com.example.demo.okta.captcha.beans.CaptchaType;

public class ReCaptchaInstance extends CaptchaInstance {
    @Override
    public CaptchaType getType() {
        return CaptchaType.RECAPTCHAV2;
    }

    public ReCaptchaInstance() {
        setScriptUrl("https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit");
        setVerifyUrl("https://www.google.com/recaptcha/api/siteverify");
        setRenderScript("function onloadCallback() {\n" +
                "                console.log(\"onloadCallback\");\n" +
                "                grecaptcha.render('myBtn', {\n" +
                "                   'sitekey' : captchaConfigResponse.sitekey,\n" +
                "                   'callback' : verifyCaptchaChallenge\n" +
                "                });\n" +
                "            }");
    }
}
