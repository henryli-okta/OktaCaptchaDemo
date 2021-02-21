package com.example.demo.okta.captcha.beans.instances;

public abstract class CaptchaInstance extends CaptchaInstanceRequestPayload {
    private String id;
    private String scriptUrl;
    private String verifyUrl;
    private String renderScript;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScriptUrl() {
        return scriptUrl;
    }

    public void setScriptUrl(String scriptUrl) {
        this.scriptUrl = scriptUrl;
    }

    public String getVerifyUrl() {
        return verifyUrl;
    }

    public void setVerifyUrl(String verifyUrl) {
        this.verifyUrl = verifyUrl;
    }

    public String getRenderScript() {
        return renderScript;
    }

    public void setRenderScript(String renderScript) {
        this.renderScript = renderScript;
    }
}
