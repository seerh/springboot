package com.seerh.springboot.domain;

import java.io.Serializable;

public class WSMessage implements Serializable {

    private static final long serialVersionUID = 5060597512366818255L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
