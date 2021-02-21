package com.example.demo.okta.captcha.services;

import com.example.demo.okta.captcha.beans.CaptchaType;
import com.example.demo.okta.captcha.beans.instances.CaptchaInstance;
import com.example.demo.okta.captcha.beans.instances.CaptchaInstanceRequestPayload;
import com.example.demo.okta.captcha.beans.instances.ReCaptchaInstance;
import com.example.demo.okta.captcha.beans.instances.HCaptchaInstance;
import com.example.demo.okta.exceptions.CaptchaInstanceNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CaptchaInstanceService {

    private static final String hCaptchaSiteKey = "xxxx";
    private static final String hCaptchaSecretKey = "xxxx";

    private static final String reCaptchaSiteKey = "xxxx";
    private static final String reCaptchaSecretKey = "xxxxx";

    private List<CaptchaInstance> captchaInstanceList;

    public CaptchaInstanceService() {
        captchaInstanceList = new ArrayList<>();

        CaptchaInstanceRequestPayload hCaptchaInstance = new CaptchaInstanceRequestPayload();
        hCaptchaInstance.setName("myHCaptchaInstance");
        hCaptchaInstance.setSiteKey(hCaptchaSiteKey);
        hCaptchaInstance.setSecretKey(hCaptchaSecretKey);
        hCaptchaInstance.setType(CaptchaType.valueOf("HCAPTCHA"));
        addCaptchaInstance(hCaptchaInstance);

        CaptchaInstanceRequestPayload reCaptchaInstance = new CaptchaInstanceRequestPayload();
        reCaptchaInstance.setName("myReCaptchaInstance");
        reCaptchaInstance.setSiteKey(reCaptchaSiteKey);
        reCaptchaInstance.setSecretKey(reCaptchaSecretKey);
        reCaptchaInstance.setType(CaptchaType.valueOf("RECAPTCHAV2"));
        addCaptchaInstance(reCaptchaInstance);
    }

    public CaptchaInstance getCaptchaInstanceById(String id) {
        for (CaptchaInstance captchaInstance : captchaInstanceList) {
            if (captchaInstance.getId().equals(id)) {
                return captchaInstance;
            }
        }
        throw new CaptchaInstanceNotFoundException("Cannot find captcha instance with id="+id);
    }

    public List<CaptchaInstance> getCaptchaInstances() {
        return captchaInstanceList;
    }

    public CaptchaInstance addCaptchaInstance(CaptchaInstanceRequestPayload newCaptchaInstance) {
        CaptchaType captchaType = newCaptchaInstance.getType();
        CaptchaInstance captchaInstance = null;
        switch (captchaType) {
            case HCAPTCHA:
                captchaInstance = new HCaptchaInstance();
                captchaInstance.setId("123");
                break;
            case RECAPTCHAV2:
                captchaInstance = new ReCaptchaInstance();
                captchaInstance.setId("456");
                break;
        }
        if (captchaInstance != null) {
            captchaInstance.setSiteKey(newCaptchaInstance.getSiteKey());
            captchaInstance.setSecretKey(newCaptchaInstance.getSecretKey());
            captchaInstance.setName(newCaptchaInstance.getName());
            captchaInstanceList.add(captchaInstance);
        }
        return captchaInstance;
    }
}
