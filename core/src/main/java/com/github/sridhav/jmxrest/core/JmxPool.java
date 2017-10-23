package com.github.sridhav.jmxrest.core;


import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class JmxPool<T> extends GenericObjectPool<T> {
    public JmxPool(PooledObjectFactory<T> factory) {
        super(factory);
    }

    public JmxPool(PooledObjectFactory<T> factory, GenericObjectPoolConfig config) {
        super(factory, config);
    }
}
