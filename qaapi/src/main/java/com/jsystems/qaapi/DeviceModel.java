package com.jsystems.qaapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeviceModel {
    @JsonProperty(required = true)
    public String produce;

    @JsonProperty(value = "srceen.size", required = true)
    public int screenSize;
}
