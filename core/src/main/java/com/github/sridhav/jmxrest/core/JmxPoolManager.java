package com.github.sridhav.jmxrest.core;

import com.github.sridhav.jmxrest.config.JmxConfig;
import com.github.sridhav.jmxrest.config.JmxProperties;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.log4j.Logger;

import javax.management.remote.JMXConnector;

public class JmxPoolManager {

    private GenericObjectPoolConfig config;

    private JmxPool pool = null;

    private final static Logger LOGGER = Logger.getLogger(JmxPoolManager.class);


    public JmxPoolManager(JmxProperties jmxProperties, String namespace) {
        JmxProperties poolProperties = jmxProperties.getPropertiesByPattern("pool");
        initObjectPoolConfig(poolProperties);
        this.setPool(new JmxPool<JMXConnector>(new JmxPoolFactory<JMXConnector>(jmxProperties, namespace)));
    }

    private void initObjectPoolConfig(JmxProperties poolProperties) {
        if (config == null) {
            config = new GenericObjectPoolConfig();
            config.setMaxIdle(Integer.parseInt(poolProperties.getProperty(JmxConfig.POOL_MAX_IDLE)));
            config.setMaxTotal(Integer.parseInt(poolProperties.getProperty(JmxConfig.POOL_MIN_IDLE)));
            config.setMaxTotal(Integer.parseInt(poolProperties.getProperty(JmxConfig.POOL_MAX_TOTAL)));
            config.setJmxEnabled(Boolean.parseBoolean(poolProperties.getProperty(JmxConfig.POOL_JMX_ENABLED)));
            config.setTestOnBorrow(Boolean.parseBoolean(poolProperties.getProperty(JmxConfig.POOL_TEST_ON_BORROW)));
            config.setTestOnCreate(Boolean.parseBoolean(poolProperties.getProperty(JmxConfig.POOL_TEST_ON_CREATE)));
            config.setTestOnReturn(Boolean.parseBoolean(poolProperties.getProperty(JmxConfig.POOL_TEST_ON_RETURN)));
        }
    }

    public JmxPoolManager(JmxConnectionConfig connectionConfig) {
        this.setPool(new JmxPool<JMXConnector>(new JmxPoolFactory<JMXConnector>(connectionConfig)));
    }

    public JmxPoolManager(JmxConnectionConfig connectionConfig, GenericObjectPoolConfig objectPoolConfig) {
        this.setConfig(objectPoolConfig);
        this.setPool(new JmxPool<JMXConnector>(new JmxPoolFactory<JMXConnector>(connectionConfig)));
    }
    public JMXConnector getConnectionFromPool() {
        JMXConnector jmxConnector = null;
        try {
            jmxConnector = (JMXConnector) this.getPool().borrowObject();
            LOGGER.info("Pool stats - Created:[" + this.getPool().getCreatedCount() + "], Active:" + this.getPool().getNumActive() + "], Idle: " + this.getPool().getNumIdle() +"], Borrowed: ["+this.getPool().getBorrowedCount()+"]");
            if(LOGGER.isDebugEnabled()) {
                LOGGER.debug("Pool stats - Created:[" + this.getPool().getCreatedCount() + "], Borrowed: ["+this.getPool().getBorrowedCount()+"]");
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return jmxConnector;
    }


    public void returnConnectionToPool(JMXConnector jmxConnector) {
        if (this.getPool() == null) {
            if(LOGGER.isDebugEnabled()) {
                LOGGER.debug("Invalid Pool state");
            }
        }
        try {
            this.getPool().returnObject(jmxConnector);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }

    }

    public  void cleanup() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Cleaning up pool");
        }
        this.getPool().close();
    }


    public GenericObjectPoolConfig getConfig() {
        return config;
    }

    public void setConfig(GenericObjectPoolConfig config) {
        this.config = config;
    }

    public JmxPool getPool() {
        return pool;
    }

    public void setPool(JmxPool pool) {
        this.pool = pool;
    }
}
