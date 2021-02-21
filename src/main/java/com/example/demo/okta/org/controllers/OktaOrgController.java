package com.example.demo.okta.org.controllers;

import com.example.demo.okta.org.beans.OrgCaptchaConfig;
import com.example.demo.okta.org.beans.OrgCaptchaFFResponse;
import com.example.demo.okta.org.services.OktaOrgConfigurationService;
import com.example.demo.okta.exceptions.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OktaOrgController {

    @Autowired
    OktaOrgConfigurationService orgConfigurationService;

    @RequestMapping(path = "/siw/org/config/captcha/feature_flag", method = RequestMethod.GET)
    public OrgCaptchaFFResponse hasEnableCaptchaSupportFF() {
        return orgConfigurationService.hasEnableCaptchaSupportFF();
    }

    @RequestMapping(path = "/siw/org/config/captcha", method = RequestMethod.GET)
    public OrgCaptchaConfig getOrgCaptchaConfigFromSIW() {
        return orgConfigurationService.getOrgCaptchaConfiguration();
    }

    @RequestMapping(path = "/api/v1/org/config/captcha", method = RequestMethod.GET)
    public OrgCaptchaConfig getOrgCaptchaConfig(@RequestParam("token") String authorizeToken) {
        //simulate authentication by authorize token
        if (!StringUtils.hasText(authorizeToken)) {
            throw new InvalidInputException("invalid authorize token");
        }
        return orgConfigurationService.getOrgCaptchaConfiguration();
    }

    @RequestMapping(path = "/api/v1/org/config/captcha", method = {RequestMethod.PUT, RequestMethod.POST})
    public OrgCaptchaConfig updateOrgCaptchaConfig(@RequestParam("token") String authorizeToken, OrgCaptchaConfig updateOrgCaptchaConfig) {
        //simulate authentication by authorize token
        if (!StringUtils.hasText(authorizeToken)) {
            throw new InvalidInputException("invalid authorize token");
        }
        return orgConfigurationService.updateOrgCaptchaConfiguration(updateOrgCaptchaConfig);
    }
}
