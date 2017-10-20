package com.github.sridhav.jmxrest.config;

public class ConfigDef {
    private String key;

    private String defaultValue;

    private String description;

    public ConfigDef(String key, String defaultValue, String description) {
        this.key = key;
        this.defaultValue = defaultValue;
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ConfigDef define(String key, String defaultValue, String description) {
        return new ConfigDef(key, defaultValue, description);
    }
}
