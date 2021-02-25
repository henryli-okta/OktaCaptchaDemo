package com.example.demo.okta.captcha.services.providers;

import com.example.demo.okta.captcha.beans.CaptchaType;
import com.example.demo.okta.captcha.beans.CaptchaVerifyResponse;
import com.example.demo.okta.exceptions.InvalidInputException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

public class ReCaptchaProviderImpl extends CaptchaProviderImpl {

    private static final Logger LOG = LoggerFactory.getLogger(ReCaptchaProviderImpl.class);

    public ReCaptchaProviderImpl() {
        setVerifyUrl("https://www.google.com/recaptcha/api/siteverify");
    }

    @Override
    public CaptchaType getType() {
        return CaptchaType.RECAPTCHAV2;
    }

    @Override
    public CaptchaVerifyResponse checkCaptchaVerifyResult(String token) {
        if (!StringUtils.hasText(token)) {
            throw new InvalidInputException("token is empty");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(MediaType.APPLICATION_FORM_URLENCODED_VALUE));

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("response", token);
        map.add("secret", getCaptchaInstance().getSecretKey());
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<CaptchaVerifyResponse> response = restTemplate.exchange(getVerifyUrl(), HttpMethod.POST, request, CaptchaVerifyResponse.class);

        LOG.info("CAPTCHA verify executed for provider={}, result={}, clientIP={}, time={}",
                "hCaptcha",response.getBody().isSuccess(), response.getBody().getHostname(), response.getBody().getChallenge_ts());

        return response.getBody();
    }
}
