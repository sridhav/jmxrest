package com.github.sridhav.jmxrest.core;

import org.apache.log4j.Logger;

import javax.management.remote.JMXServiceURL;
import java.net.MalformedURLException;

public class JmxConnectionConfig {
    private String hostname;

    private Integer port;

    private String username;

    private String password;

    private String sslKeystoreLocation;

    private String sslTruststoreLocation;

    private String sslKeystorePassword;

    private String sslKeyPassword;

    private String sslTruststorePasssword;

    private final static Logger LOGGER = Logger.getLogger(JmxConnectionConfig.class);

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSslKeystoreLocation() {
        return sslKeystoreLocation;
    }

    public void setSslKeystoreLocation(String sslKeystoreLocation) {
        this.sslKeystoreLocation = sslKeystoreLocation;
    }

    public String getSslTruststoreLocation() {
        return sslTruststoreLocation;
    }

    public void setSslTruststoreLocation(String sslTruststoreLocation) {
        this.sslTruststoreLocation = sslTruststoreLocation;
    }

    public String getSslKeystorePassword() {
        return sslKeystorePassword;
    }

    public void setSslKeystorePassword(String sslKeystorePassword) {
        this.sslKeystorePassword = sslKeystorePassword;
    }

    public String getSslKeyPassword() {
        return sslKeyPassword;
    }

    public void setSslKeyPassword(String sslKeyPassword) {
        this.sslKeyPassword = sslKeyPassword;
    }

    public String getSslTruststorePasssword() {
        return sslTruststorePasssword;
    }

    public void setSslTruststorePasssword(String sslTruststorePasssword) {
        this.sslTruststorePasssword = sslTruststorePasssword;
    }

    public JMXServiceURL getJMXServiceURL() {
        JMXServiceURL jmxServiceURL = null;
        String jmxUrl = String.format("service:jmx:rmi:///jndi/rmi://%s:%d/jmxrmi", this.getHostname(), this.getPort());
        try {
            jmxServiceURL = new JMXServiceURL(jmxUrl);
        } catch (MalformedURLException e) {
            LOGGER.error(e.getMessage());
        }
        return jmxServiceURL;
    }

}
