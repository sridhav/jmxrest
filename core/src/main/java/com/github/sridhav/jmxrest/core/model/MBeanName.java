package com.github.sridhav.jmxrest.core.model;


import java.util.Map;
import java.util.Properties;

public class MBeanName {

    private String domain;

    private Properties properties = new Properties();

    private String objectName;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public static Properties buildPropsFromObjectName(String objectName) {
        String[] firstSplit = objectName.split(":");
        Properties properties = new Properties();
        if (firstSplit.length == 2) {
            String[] secondSplit = firstSplit[1].split(",");
            for(String string: secondSplit) {
                String[] thirdSplit = string.split("=");
                if(thirdSplit.length == 2) {
                    properties.setProperty(thirdSplit[0], thirdSplit[1]);
                }
            }
        }
        return properties;
    }

    public static String buildObjectName(String domain, Properties properties) {
        StringBuilder buffer = new StringBuilder();
        for(Map.Entry<Object, Object> e: properties.entrySet()){
            buffer.append(String.format("%s=%s,", e.getKey(), e.getValue()));
        }
        String output = buffer.toString().substring(0, buffer.length() -1);
        return String.format("%s:%s", domain, output);
    }
}
