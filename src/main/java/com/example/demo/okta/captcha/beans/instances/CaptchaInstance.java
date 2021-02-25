package com.example.demo.okta.captcha.beans.instances;

import com.example.demo.okta.captcha.views.Views;
import com.fasterxml.jackson.annotation.JsonView;

public abstract class CaptchaInstance extends CaptchaInstanceRequestPayload {
    @JsonView(Views.PublicView.class)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
