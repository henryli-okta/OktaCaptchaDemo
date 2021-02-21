package com.example.demo.okta.captcha.controllers;

import com.example.demo.okta.captcha.beans.CaptchaConfigResponse;
import com.example.demo.okta.captcha.beans.instances.CaptchaInstanceRequestPayload;
import com.example.demo.okta.captcha.services.CaptchaInstanceService;
import com.example.demo.okta.captcha.beans.CaptchaVerifyResponse;
import com.example.demo.okta.captcha.beans.instances.CaptchaInstance;
import com.example.demo.okta.captcha.services.CaptchaProviderHelper;
import com.example.demo.okta.captcha.services.providers.CaptchaProvider;
import com.example.demo.okta.exceptions.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OktaCaptchaController {

    @Autowired
    private CaptchaInstanceService captchaInstanceService;

    @Autowired
    private CaptchaProviderHelper captchaProviderHelper;

    @RequestMapping(path = "/siw/captchas/{captchaInstanceId}/config", method = RequestMethod.GET)
    public CaptchaConfigResponse getCaptchaConfigFromSIW(@PathVariable(name = "captchaInstanceId") String captchaInstanceId) {
        CaptchaConfigResponse captchaConfigResponse = new CaptchaConfigResponse();
        CaptchaInstance captchaInstance = captchaInstanceService.getCaptchaInstanceById(captchaInstanceId);
        if (captchaInstance != null) {
            captchaConfigResponse.setId(captchaInstance.getId());
            captchaConfigResponse.setSiteKey(captchaInstance.getSiteKey());
            captchaConfigResponse.setType(captchaInstance.getType().getAppName());
            captchaConfigResponse.setScriptUrl(captchaInstance.getScriptUrl());
            captchaConfigResponse.setRenderScript(captchaInstance.getRenderScript());
        }

        return captchaConfigResponse;
    }

    @RequestMapping(path = "/siw/captchas/{captchaInstanceId}/verify", method = RequestMethod.POST)
    public CaptchaVerifyResponse verify(
            @RequestParam("token") String token,
            @PathVariable(name = "captchaInstanceId") String captchaInstanceId) {
        CaptchaInstance captchaInstance = captchaInstanceService.getCaptchaInstanceById(captchaInstanceId);
        CaptchaProvider captchaProvider = captchaProviderHelper.getCaptchaProvider(captchaInstance);
        captchaProvider.setCaptchaInstance(captchaInstance);
        return captchaProvider.checkCaptchaVerifyResult(token);
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
            CaptchaInstanceRequestPayload newCaptchaInstance) {
        //simulate authentication by authorize token
        if (!StringUtils.hasText(authorizeToken)) {
            throw new InvalidInputException("invalid authorize token");
        }
        return captchaInstanceService.addCaptchaInstance(newCaptchaInstance);
    }

}
