package com.example.demo.okta.captcha.beans.instances;

import com.example.demo.beans.User;

public class CaptchaVerifyRegisterRequestPayload {
    private String token;
    private String instanceId;
    private User userProfile;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public User getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(User userProfile) {
        this.userProfile = userProfile;
    }
}
