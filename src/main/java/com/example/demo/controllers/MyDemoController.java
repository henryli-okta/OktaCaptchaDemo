package com.example.demo.controllers;

import com.example.demo.okta.captcha.services.CaptchaInstanceService;
import com.example.demo.okta.captcha.services.CaptchaProviderHelper;
import com.example.demo.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyDemoController {

    @Autowired
    private CaptchaProviderHelper captchaProviderHelper;

    @Autowired
    private CaptchaInstanceService captchaInstanceService;

    @Autowired
    private Environment env;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(path = "/captcha", method = {RequestMethod.GET, RequestMethod.POST})
    public String captchaPage(Model model) {
        Boolean useOrgCaptchaConfig = Boolean.valueOf(env.getProperty("config.useOrgCaptchaConfig"));
        model.addAttribute("useOrgCaptchaConfig", useOrgCaptchaConfig);

        Boolean appCaptchaConfigEnabled = Boolean.valueOf(env.getProperty("config.appCaptchaConfig.enabled"));
        model.addAttribute("appCaptchaConfigEnabled", appCaptchaConfigEnabled);

        String appCaptchaInstanceId= env.getProperty("config.appCaptchaConfig.instanceId");
        model.addAttribute("appCaptchaInstanceId", appCaptchaInstanceId);

        return "captcha";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("username") String name, @RequestParam("email") String email, Model model) {
        User user = new User(name, email);
        model.addAttribute("user", user);
        model.addAttribute("message", "123456");
        return "user_dashboard";
    }
}
