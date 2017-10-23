package com.github.sridhav.jmxrest.core;


import com.github.sridhav.jmxrest.core.model.MBean;
import org.apache.log4j.PropertyConfigurator;

import javax.management.MalformedObjectNameException;
import java.util.List;

public class Main {
    static {
        PropertyConfigurator.configure(Main.class.getResource("/log4j.properties").getFile());
    }

    public static void main(String[] args) throws MalformedObjectNameException {
        JmxConnectionConfig connectionConfig = new JmxConnectionConfig();
        connectionConfig.setHostname("localhost");
        connectionConfig.setPort(1617);
        JmxService jmxService = new JmxService(connectionConfig);
        List<MBean> list = jmxService.getAllMbeans("java.lang");
    }
}
