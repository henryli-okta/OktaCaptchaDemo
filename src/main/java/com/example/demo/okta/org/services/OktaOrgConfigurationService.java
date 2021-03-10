package com.example.demo.okta.org.services;

import com.example.demo.okta.captcha.beans.instances.CaptchaInstance;
import com.example.demo.okta.captcha.services.CaptchaInstanceService;
import com.example.demo.okta.org.beans.OrgCaptchaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OktaOrgConfigurationService {

    public boolean hasEnableCaptchaSupportFF() {
        return true;
    }

    public OrgCaptchaConfig getOrgCaptchaConfiguration() {
        OrgCaptchaConfig orgCaptchaConfig = new OrgCaptchaConfig();
        orgCaptchaConfig.getEnabledPages().add("ssr");
        orgCaptchaConfig.setInstanceId("123");
        return orgCaptchaConfig;
    }

    public OrgCaptchaConfig updateOrgCaptchaConfiguration(OrgCaptchaConfig updateOrgCaptchaConfig) {
        return updateOrgCaptchaConfig;
    }
}
