package com.example.demo.okta.org.controllers;

import com.example.demo.okta.captcha.beans.instances.CaptchaInstance;
import com.example.demo.okta.captcha.services.CaptchaInstanceService;
import com.example.demo.okta.captcha.views.Views;
import com.example.demo.okta.org.beans.OrgCaptchaConfig;
import com.example.demo.okta.org.beans.OrgCaptchaConfigResponse;
import com.example.demo.okta.org.services.OktaOrgConfigurationService;
import com.example.demo.okta.exceptions.InvalidInputException;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class OktaOrgController {

    @Autowired
    private OktaOrgConfigurationService orgConfigurationService;

    @Autowired
    private CaptchaInstanceService captchaInstanceService;

    @JsonView(Views.PublicView.class)
    @RequestMapping(path = "/siw/org/config/captcha", method = RequestMethod.GET)
    public OrgCaptchaConfigResponse getOrgCaptchaConfigFromSIW() {
        OrgCaptchaConfig orgCaptchaConfig =  orgConfigurationService.getOrgCaptchaConfiguration();
        if (!orgConfigurationService.hasEnableCaptchaSupportFF()) {
            orgCaptchaConfig.setEnabledPages(new ArrayList<>());
        }
        return populatedOrgCaptchaConfigResponse(orgCaptchaConfig);
    }

    @RequestMapping(path = "/api/v1/org/config/captcha", method = RequestMethod.GET)
    public OrgCaptchaConfigResponse getOrgCaptchaConfig(@RequestParam("token") String authorizeToken) {
        //simulate authentication by authorize token
        if (!StringUtils.hasText(authorizeToken)) {
            throw new InvalidInputException("invalid authorize token");
        }
        OrgCaptchaConfig orgCaptchaConfig =  orgConfigurationService.getOrgCaptchaConfiguration();
        return populatedOrgCaptchaConfigResponse(orgCaptchaConfig);
    }

    @RequestMapping(path = "/api/v1/org/config/captcha", method = {RequestMethod.PUT, RequestMethod.POST})
    public OrgCaptchaConfigResponse updateOrgCaptchaConfig(@RequestParam("token") String authorizeToken,
                                                   @RequestBody OrgCaptchaConfig updateOrgCaptchaConfig) {
        //simulate authentication by authorize token
        if (!StringUtils.hasText(authorizeToken)) {
            throw new InvalidInputException("invalid authorize token");
        }
        OrgCaptchaConfig updateOrgCaptchaConfiguration =  orgConfigurationService.updateOrgCaptchaConfiguration(updateOrgCaptchaConfig);
        return populatedOrgCaptchaConfigResponse(updateOrgCaptchaConfiguration);
    }

    private OrgCaptchaConfigResponse populatedOrgCaptchaConfigResponse(OrgCaptchaConfig orgCaptchaConfig) {
        OrgCaptchaConfigResponse orgCaptchaConfigResponse = new OrgCaptchaConfigResponse();
        CaptchaInstance captchaInstance = captchaInstanceService.getCaptchaInstanceById(orgCaptchaConfig.getInstanceId());
        orgCaptchaConfigResponse.setCaptchaInstance(captchaInstance);
        orgCaptchaConfigResponse.setEnabledPages(orgCaptchaConfig.getEnabledPages());
        return orgCaptchaConfigResponse;
    }
}
