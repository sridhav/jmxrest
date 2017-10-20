package com.github.sridhav.jmxrest.core;

import com.github.sridhav.jmxrest.core.model.JmxBean;
import org.apache.commons.pool2.impl.GenericObjectPool;

import javax.management.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JmxService {

    private GenericObjectPool<JmxConnection> genericObjectPool = null;

    private JmxConnection jmxConnection = null;

    private JmxConnectionConfig jmxConnectionConfig = null;

    public JmxService(JmxConnectionConfig jmxConnectionConfig) {
        this.jmxConnectionConfig  = jmxConnectionConfig;
        init();
    }

    public JmxService(String hostname, Integer port) {
        JmxConnectionConfig connectionConfig = new JmxConnectionConfig();
        connectionConfig.setHostname(hostname);
        connectionConfig.setPort(port);
        this.setJmxConnectionConfig(jmxConnectionConfig);
        init();
    }

    private void init() {
        JmxConnectionFactory jmxConnectionFactory = new JmxConnectionFactory(this.getJmxConnectionConfig());
        GenericObjectPool<JmxConnection> genericObjectPool = new GenericObjectPool<JmxConnection>(jmxConnectionFactory);
        this.setGenericObjectPool(genericObjectPool);
    }

    public List<String> getDomains() {
        List<String> domains = new ArrayList<>();
        try {
            domains = Arrays.asList(this.getConnection().getDomains());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return domains;
    }

    public String getDefaultDomain() {
        String domain = null;
        try {
            domain = this.getConnection().getDefaultDomain();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return domain;
    }

    public GenericObjectPool<JmxConnection> getGenericObjectPool() {
        return genericObjectPool;
    }

    public void setGenericObjectPool(GenericObjectPool<JmxConnection> genericObjectPool) {
        this.genericObjectPool = genericObjectPool;
    }

    public JmxConnection getJmxConnection() {
        return this.jmxConnection;
    }

    public void setJmxConnection(JmxConnection jmxConnection) {
        this.jmxConnection = jmxConnection;
    }



    public MBeanServerConnection getConnection() {
        MBeanServerConnection mBeanServerConnection = null;
        try {
             JmxConnection jmxConnection = this.getGenericObjectPool().borrowObject();
             this.setJmxConnection(jmxConnection);
             System.out.println(jmxConnection);
             mBeanServerConnection = jmxConnection.getmBeanServerConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mBeanServerConnection;
    }

    public void releaseConnection() {
        if (this.getJmxConnection() != null) {
            this.getGenericObjectPool().returnObject(this.getJmxConnection());
        }
    }

    public JmxConnectionConfig getJmxConnectionConfig() {
        return jmxConnectionConfig;
    }


    public void setJmxConnectionConfig(JmxConnectionConfig jmxConnectionConfig) {
        this.jmxConnectionConfig = jmxConnectionConfig;
    }


    public JmxBean getAttribute(String query) {
        QueryService queryService = new QueryService(query);
        JmxBean jmxBean = queryService.getJmxBeanWithValue(this.getConnection());
        this.releaseConnection();

        return jmxBean;
    }


    public JmxBean getAttribute(String domain, String name, String type, String attribute) {
        JmxBean jmxBean = new JmxBean();
        if (!(CoreUtils.isNullOrEmpty(domain) || CoreUtils.isNullOrEmpty(type) || CoreUtils.isNullOrEmpty(attribute))) {
            String query = String.format(CoreUtils.TEMPLATE_JMX_BEAN, domain, type, attribute);
            if (!(CoreUtils.isNullOrEmpty(name))){
                query = String.format(CoreUtils.TEMPLATE_JMX_BEAN_NAME, domain, type, attribute, name);
            }
            jmxBean = this.getAttribute(query);
        }

        return jmxBean;
    }


    public JmxBean getAttribute(String objectName, String attribute) {
        String query = CoreUtils.convertObjectNameToQuery(objectName, attribute);
        return this.getAttribute(query);
    }

    public JmxBean getAttribute(ObjectName objectName, String attribute) {
        String objectNameString = objectName.getCanonicalName();
        return this.getAttribute(objectNameString, attribute);
    }

}
