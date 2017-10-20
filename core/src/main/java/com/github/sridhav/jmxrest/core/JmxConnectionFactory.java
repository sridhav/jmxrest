package com.github.sridhav.jmxrest.core;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class JmxConnectionFactory extends BasePooledObjectFactory<JmxConnection> {

    private JmxConnectionConfig jmxConnectionConfig = null;

    public JmxConnectionFactory(JmxConnectionConfig connectionConfig) {
        this.setJmxConnectionConfig(connectionConfig);
    }

    @Override
    public JmxConnection create() throws Exception {
        return new JmxConnection(this.getJmxConnectionConfig().getHostname(), this.getJmxConnectionConfig().getPort());
    }

    @Override
    public PooledObject<JmxConnection> wrap(JmxConnection jmxConnection) {
        return new DefaultPooledObject<JmxConnection>(jmxConnection);
    }

    public JmxConnectionConfig getJmxConnectionConfig() {
        return jmxConnectionConfig;
    }

    public void setJmxConnectionConfig(JmxConnectionConfig jmxConnectionConfig) {
        this.jmxConnectionConfig = jmxConnectionConfig;
    }
}
