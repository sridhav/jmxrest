package com.github.sridhav.jmxrest.config;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class JmxConfigurator {

    private static JmxProperties allProperties = new JmxProperties();

    private static JmxProperties defaultProperties = new JmxProperties();

    public static JmxProperties load(File file) {
        try {
            defaultProperties.load(JmxConfigurator.class.getResourceAsStream("/default.properties"));
            allProperties.load(new FileReader(file));
            afterLoad();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  allProperties;
    }

    public static JmxProperties load(String filename) {
        return load(new File(filename));
    }

    private static void afterLoad() {
        List<String> namespaces = allProperties.getNamespaceList();
        namespaces.add("rest");
        JmxProperties properties = defaultProperties.getPropertiesByPattern("ssl");
        for(String namespace: namespaces) {
            for (Map.Entry entry: properties.entrySet()) {
                String namespaceKey = String.format("%s.%s", namespace, entry.getKey().toString());
                if(!allProperties.containsKey(namespaceKey)){
                    allProperties.setProperty(namespaceKey, entry.getValue().toString());
                }
            }
        }
    }

    public static JmxProperties getPoolProperties(){
        return allProperties.getPropertiesByPattern("pool");
    }

    public static JmxProperties getRestProperties() {
        return allProperties.getPropertiesByPattern("rest");
    }

    public static JmxProperties getNamespaceProperties(String namespace) {
        JmxProperties properties = new JmxProperties();
        properties = allProperties.getPropertiesByPattern(namespace);
        properties.putAll(allProperties.getPoolPropeties());
        return properties;
    }

    public static JmxProperties getLogProperties() {
        return allProperties.getPropertiesByPattern("log4j");
    }

    public static Properties getMyBatisProperties() {
        return allProperties.getPropertiesByNamespace("mybatis");
    }

    public static List<String> getNamespaces() {
        return allProperties.getNamespaceList();
    }
}
