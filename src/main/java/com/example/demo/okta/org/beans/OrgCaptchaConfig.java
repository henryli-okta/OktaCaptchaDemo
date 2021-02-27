package com.example.demo.okta.org.beans;

import java.util.ArrayList;
import java.util.List;

public class OrgCaptchaConfig {
    private List<String> enabledPages = new ArrayList<>();
    private String instanceId;

    public List<String> getEnabledPages() {
        return enabledPages;
    }

    public void setEnabledPages(List<String> enabledPages) {
        this.enabledPages = enabledPages;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }
}
