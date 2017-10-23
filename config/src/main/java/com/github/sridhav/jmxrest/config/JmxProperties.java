package com.github.sridhav.jmxrest.config;

import com.sun.deploy.config.ClientConfig;

import javax.management.JMX;
import java.util.*;

public class JmxProperties extends Properties {

    JmxProperties getPropertiesByNamespace(String namespace) {
        JmxProperties properties = new JmxProperties();
        if (this.validateNamespaceInList(namespace)) {
            properties = this.getPropertiesByPattern(namespace);
        }

        return properties;
    }

    JmxProperties getPoolPropeties() {
        return getPropertiesByPattern("pool");
    }

    List<String> getNamespaceList() {
        String value = this.getProperty(JmxConfig.NAMESPACE_LIST);
        List<String> list = new ArrayList<>(Arrays.asList(value.split(",")));
        return list;
    }

    boolean validateNamespaceInList(String namespace) {
        List<String> namespaces = this.getNamespaceList();
        boolean ret  = false;
        for (String ns: namespaces) {
            if (ns.toLowerCase().equals(namespace.toLowerCase())){
                ret = true;
                break;
            }
        }
        return  ret;
    }

    public JmxProperties getPropertiesByPattern(String prefix) {
        JmxProperties properties = new JmxProperties();
        for(Map.Entry entry: this.entrySet()) {
            if (entry.getKey().toString().startsWith(prefix)) {
                properties.put(entry.getKey(), entry.getValue());
            }
        }
        return properties;
    }
}
