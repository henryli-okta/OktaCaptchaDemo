package com.example.demo.okta.org.services;

import com.example.demo.okta.org.beans.OrgCaptchaConfig;
import com.example.demo.okta.org.beans.OrgCaptchaFFResponse;
import org.springframework.stereotype.Service;

@Service
public class OktaOrgConfigurationService {
    public OrgCaptchaFFResponse hasEnableCaptchaSupportFF() {
        OrgCaptchaFFResponse ffResponse = new OrgCaptchaFFResponse();
        ffResponse.setEnabled(true);
        return ffResponse;
    }

    public OrgCaptchaConfig getOrgCaptchaConfiguration() {
        OrgCaptchaConfig orgCaptchaConfig = new OrgCaptchaConfig();
        orgCaptchaConfig.setEnabled(true);
        orgCaptchaConfig.setInstanceId("123");
        return orgCaptchaConfig;
    }

    public OrgCaptchaConfig updateOrgCaptchaConfiguration(OrgCaptchaConfig updateOrgCaptchaConfig) {
        return updateOrgCaptchaConfig;
    }
}
