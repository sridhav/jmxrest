package com.github.sridhav.jmxrest.core.services;

import org.apache.log4j.Logger;

import javax.management.MBeanServerConnection;

public class AbstractService {
    protected final static Logger LOGGER = Logger.getLogger(AbstractService.class);

    private MBeanServerConnection mbeanServerConnection;


    public AbstractService(MBeanServerConnection serverConnection) {
        this.setMbeanServerConnection(serverConnection);
    }

    public MBeanServerConnection getMbeanServerConnection() {
        return mbeanServerConnection;
    }

    public void setMbeanServerConnection(MBeanServerConnection mbeanServerConnection) {
        this.mbeanServerConnection = mbeanServerConnection;
    }
}
