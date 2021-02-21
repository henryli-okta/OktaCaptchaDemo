package com.example.demo.okta.config;

import com.example.demo.okta.captcha.services.CaptchaInstanceService;
import com.example.demo.okta.captcha.services.CaptchaProviderHelper;
import com.example.demo.okta.captcha.services.providers.HCaptchaProviderImpl;
import com.example.demo.okta.captcha.services.providers.ReCaptchaProviderImpl;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OktaConfiguration {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    @Bean
    public HCaptchaProviderImpl getHCaptchaProviderImpl() {
        return new HCaptchaProviderImpl();
    }

    @Bean
    public ReCaptchaProviderImpl getReCaptchaProviderImpl() {
        return new ReCaptchaProviderImpl();
    }

    @Bean
    public CaptchaProviderHelper getCaptchaProviderHelper() {
        return new CaptchaProviderHelper();
    }

    @Bean
    public CaptchaInstanceService getCaptchaInstanceClientAPI() {
        return new CaptchaInstanceService();
    }
}
