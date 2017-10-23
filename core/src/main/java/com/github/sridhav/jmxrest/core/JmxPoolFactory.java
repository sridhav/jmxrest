package com.github.sridhav.jmxrest.core;

import com.github.sridhav.jmxrest.config.JmxConfig;
import com.github.sridhav.jmxrest.config.JmxProperties;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.log4j.Logger;

import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.net.MalformedURLException;


public class JmxPoolFactory<T> extends BasePooledObjectFactory<T> {
    final static Logger LOGGER = Logger.getLogger(JmxPoolFactory.class);

    private JmxConnectionConfig jmxConnectionConfig;

    private JmxProperties jmxProperties;

    private String namespace;

    public JmxPoolFactory(JmxConnectionConfig jmxConnectionConfig) {
        this.setJmxConnectionConfig(jmxConnectionConfig);
    }

    public JmxPoolFactory(JmxProperties jmxProperties, String namespace) {
        this.setJmxProperties(jmxProperties);
        this.setNamespace(namespace);
    }

    @Override
    public T create() throws Exception {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Creating a new object");
        }
        JMXServiceURL jmxServiceURL = this.buildJmxUrl();
        JMXConnector jmxConnector = JMXConnectorFactory.connect(jmxServiceURL, null);

        return (T)jmxConnector;
    }

    @Override
    public PooledObject<T> wrap(T jmxConnector) {
        return  new DefaultPooledObject<T>(jmxConnector);
    }

    public void destroyObject(PooledObject<T> jmxPooledObject) throws IOException {
        JMXConnector jmxConnection = (JMXConnector) (jmxPooledObject.getObject());
        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("Destroying object: jmxConnection " + jmxConnection.toString());
        }
        jmxConnection.close();
    }


    public boolean validateObject(PooledObject<T> jmxPooledObject) {
        boolean isValidConnection = Boolean.TRUE;
        try {
            ((JMXConnector)(jmxPooledObject.getObject())).getMBeanServerConnection();
        } catch(IOException e) {
            LOGGER.error(e.getMessage());
            isValidConnection = Boolean.FALSE;
        }

        return isValidConnection;
    }

    public JmxConnectionConfig getJmxConnectionConfig() {
        return jmxConnectionConfig;
    }

    public void setJmxConnectionConfig(JmxConnectionConfig jmxConnectionConfig) {
        this.jmxConnectionConfig = jmxConnectionConfig;
    }

    public JMXServiceURL buildJmxUrl() {
        JMXServiceURL jmxServiceURL = null;
        String host = this.getJmxProperties().getProperty(String.format("%s.%s", this.getNamespace(), JmxConfig.CLIENT_HOSTNAME));
        Integer port = Integer.parseInt(this.getJmxProperties().getProperty(String.format("%s.%s", this.getNamespace(), JmxConfig.CLIENT_PORT)));
        String jmxUrl = String.format("service:jmx:rmi:///jndi/rmi://%s:%d/jmxrmi", host, port);
        try {
            jmxServiceURL = new JMXServiceURL(jmxUrl);
        } catch (MalformedURLException e) {
            LOGGER.error(e.getMessage());
        }
        return jmxServiceURL;
    }


    public JmxProperties getJmxProperties() {
        return jmxProperties;
    }

    public void setJmxProperties(JmxProperties jmxProperties) {
        this.jmxProperties = jmxProperties;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
}
