package com.example.demo.okta.captcha.controllers;

import com.example.demo.okta.captcha.beans.instances.CaptchaInstanceRequestPayload;
import com.example.demo.okta.captcha.beans.instances.CaptchaVerifyRegisterRequestPayload;
import com.example.demo.okta.captcha.services.CaptchaInstanceService;
import com.example.demo.okta.captcha.beans.CaptchaVerifyResponse;
import com.example.demo.okta.captcha.beans.instances.CaptchaInstance;
import com.example.demo.okta.captcha.services.CaptchaProviderHelper;
import com.example.demo.okta.captcha.services.providers.CaptchaProvider;
import com.example.demo.okta.captcha.services.providers.HCaptchaProviderImpl;
import com.example.demo.okta.captcha.views.Views;
import com.example.demo.okta.exceptions.InvalidInputException;
import com.example.demo.okta.org.services.OktaOrgConfigurationService;
import com.fasterxml.jackson.annotation.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OktaCaptchaController {

    private static final Logger LOG = LoggerFactory.getLogger(OktaCaptchaController.class);

    @Autowired
    private CaptchaInstanceService captchaInstanceService;

    @Autowired
    private CaptchaProviderHelper captchaProviderHelper;

    @Autowired
    private OktaOrgConfigurationService orgConfigurationService;

    @JsonView(Views.PublicView.class)
    @RequestMapping(path = "/siw/captchas/{captchaInstanceId}/config", method = RequestMethod.GET)
    public CaptchaInstance getCaptchaConfigFromSIW(@PathVariable(name = "captchaInstanceId") String captchaInstanceId) {
        if (!orgConfigurationService.hasEnableCaptchaSupportFF()) {
            return null;
        }
        return captchaInstanceService.getCaptchaInstanceById(captchaInstanceId);
    }

    @RequestMapping(path = "/api/v1/verify_and_register", method = RequestMethod.POST)
    public CaptchaVerifyResponse verifyAndRegister(@RequestBody final CaptchaVerifyRegisterRequestPayload requestPayload) {
        CaptchaInstance captchaInstance = captchaInstanceService.getCaptchaInstanceById(requestPayload.getInstanceId());
        CaptchaProvider captchaProvider = captchaProviderHelper.getCaptchaProvider(captchaInstance);
        captchaProvider.setCaptchaInstance(captchaInstance);
        CaptchaVerifyResponse verifyResponse = captchaProvider.checkCaptchaVerifyResult(requestPayload.getToken());
        if (verifyResponse.isSuccess()){
            //register user here
            LOG.warn("Register user={}", requestPayload.getUserProfile());
        }
        return verifyResponse;
    }

    @RequestMapping(path = "/api/v1/captchas/{captchaInstanceId}", method = RequestMethod.GET)
    public CaptchaInstance getCaptchaInstanceById(
            @RequestParam("token") String authorizeToken,
            @PathVariable(name = "captchaInstanceId") String captchaInstanceId) {
        //simulate authentication by authorize token
        if (!StringUtils.hasText(authorizeToken)) {
            throw new InvalidInputException("invalid authorize token");
        }
        return captchaInstanceService.getCaptchaInstanceById(captchaInstanceId);
    }

    @RequestMapping(path = "/api/v1/captchas", method = RequestMethod.GET)
    public List<CaptchaInstance> getCaptchaInstances(@RequestParam("token") String authorizeToken) {
        //simulate authentication by authorize token
        if (!StringUtils.hasText(authorizeToken)) {
            throw new InvalidInputException("invalid authorize token");
        }
        return captchaInstanceService.getCaptchaInstances();
    }

    @RequestMapping(path = "/api/v1/captchas", method = RequestMethod.POST)
    public CaptchaInstance getCaptchaInstances(
            @RequestParam("token") String authorizeToken,
            @RequestBody CaptchaInstanceRequestPayload newCaptchaInstance) {
        //simulate authentication by authorize token
        if (!StringUtils.hasText(authorizeToken)) {
            throw new InvalidInputException("invalid authorize token");
        }
        return captchaInstanceService.addCaptchaInstance(newCaptchaInstance);
    }

}
