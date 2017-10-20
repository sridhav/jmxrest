package com.github.sridhav.jmxrest.core;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.net.MalformedURLException;

public class JmxConnection {

    private static String TEMPLATE_URL = "service:jmx:rmi:///jndi/rmi://%s:%d/jmxrmi";

    private JMXServiceURL jmxServiceURL = null;

    private JMXConnector jmxConnector = null;

    private MBeanServerConnection mBeanServerConnection = null;

    public JmxConnection(String hostname, int port) {
        init(hostname, port);
    }

    private void init(String hostname, int port) {
        String jmxUrl = String.format(JmxConnection.TEMPLATE_URL, hostname, port);

        try {
            JMXServiceURL jmxServiceURL = new JMXServiceURL(jmxUrl);
            this.setJmxServiceURL(jmxServiceURL);
            JMXConnector jmxConnector = JMXConnectorFactory.connect(this.getJmxServiceURL(), null);
            this.setJmxConnector(jmxConnector);
            MBeanServerConnection mBeanServerConnection = jmxConnector.getMBeanServerConnection();
            this.setmBeanServerConnection(mBeanServerConnection);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MBeanServerConnection getmBeanServerConnection() {
        return mBeanServerConnection;
    }

    public void setmBeanServerConnection(MBeanServerConnection mBeanServerConnection) {
        this.mBeanServerConnection = mBeanServerConnection;
    }

    public JMXServiceURL getJmxServiceURL() {
        return jmxServiceURL;
    }

    public void setJmxServiceURL(JMXServiceURL jmxServiceURL) {
        this.jmxServiceURL = jmxServiceURL;
    }


    public JMXConnector getJmxConnector() {
        return jmxConnector;
    }

    public void setJmxConnector(JMXConnector jmxConnector) {
        this.jmxConnector = jmxConnector;
    }
}
