package com.example.demo.okta.captcha.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CaptchaConfigResponse {
    private String id;
    @JsonProperty("sitekey")
    private String siteKey;
    private String type;
    private String scriptUrl;
    private String renderScript;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSiteKey() {
        return siteKey;
    }

    public void setSiteKey(String siteKey) {
        this.siteKey = siteKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getScriptUrl() {
        return scriptUrl;
    }

    public void setScriptUrl(String scriptUrl) {
        this.scriptUrl = scriptUrl;
    }

    public String getRenderScript() {
        return renderScript;
    }

    public void setRenderScript(String renderScript) {
        this.renderScript = renderScript;
    }
}
