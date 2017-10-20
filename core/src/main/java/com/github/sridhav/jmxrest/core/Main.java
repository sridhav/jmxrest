package com.github.sridhav.jmxrest.core;

import javax.management.MalformedObjectNameException;

public class Main {

    public static void main(String[] args) throws MalformedObjectNameException {
        JmxConnectionConfig connectionConfig = new JmxConnectionConfig();
        connectionConfig.setHostname("localhost");
        connectionConfig.setPort(1617);
        JmxService jmxAccessor = new JmxService(connectionConfig);
    }
}
