package com.seerh.springboot.domain;

import java.io.Serializable;

public class WSResponse implements Serializable {

    private static final long serialVersionUID = 1833346722400448081L;

    private String responseMessage;

    public WSResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
