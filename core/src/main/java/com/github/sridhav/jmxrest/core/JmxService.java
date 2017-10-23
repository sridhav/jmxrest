package com.github.sridhav.jmxrest.core;

import com.github.sridhav.jmxrest.core.model.MBean;
import com.github.sridhav.jmxrest.core.services.MBeanService;
import org.apache.log4j.Logger;
import com.github.sridhav.jmxrest.config.JmxProperties;

import javax.management.*;
import javax.management.remote.JMXConnector;
import java.io.IOException;
import java.util.*;

public class JmxService {

    private JmxPoolManager jmxPoolManager;

    private JMXConnector jmxConnector = null;

    private final static Logger LOGGER = Logger.getLogger(JmxService.class);


    public JmxService(JmxProperties jmxProperties, String namespace) {
        this.setJmxPoolManager(new JmxPoolManager(jmxProperties, namespace));
    }

    public JmxService(JmxConnectionConfig jmxConnectionConfig) {
        jmxPoolManager = new JmxPoolManager(jmxConnectionConfig);
    }

    public List<String> getDomains() {
        List<String> domains = new ArrayList<>();
        try {
            domains = Arrays.asList(this.getConnection().getDomains());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        } finally {
            this.releaseConnection();
        }

        return domains;
    }

    public String getDefaultDomain() {
        String domain = null;
        try {
            domain = this.getConnection().getDefaultDomain();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        } finally {
            this.releaseConnection();
        }
        return domain;
    }


    public List<MBean> getAllMbeans(String domain) {
        MBeanService mBeanService = new MBeanService(this.getConnection());
        List<MBean> mBeans = mBeanService.getAllMbeans(domain);
        this.releaseConnection();
        return mBeans;
    }



    public MBeanServerConnection getConnection() {
        MBeanServerConnection mBeanServerConnection = null;
        try {
           mBeanServerConnection =  this.getJmxConnector().getMBeanServerConnection();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return mBeanServerConnection;
    }



    public JMXConnector getJmxConnector() {
        if (jmxConnector == null) {
            this.setJmxConnector(jmxPoolManager.getConnectionFromPool());
        }
        return jmxConnector;
    }


    public void releaseConnection() {
        if (this.getJmxConnector() != null) {
            jmxPoolManager.returnConnectionToPool(this.getJmxConnector());
            this.setJmxConnector(null);
        }
    }

    public void setJmxConnector(JMXConnector jmxConnector) {
        this.jmxConnector = jmxConnector;
    }

    public JmxPoolManager getJmxPoolManager() {
        return jmxPoolManager;
    }

    public void setJmxPoolManager(JmxPoolManager jmxPoolManager) {
        this.jmxPoolManager = jmxPoolManager;
    }

}
