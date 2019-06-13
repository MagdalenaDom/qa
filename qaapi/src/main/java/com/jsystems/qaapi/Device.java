package com.jsystems.qaapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Device {
    public String type;
    @JsonProperty(value = "device.model", required = true)
    public List<Device> deviceModel;
}
