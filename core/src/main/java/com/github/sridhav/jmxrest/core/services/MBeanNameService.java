package com.github.sridhav.jmxrest.core.services;

import com.github.sridhav.jmxrest.core.model.MBeanName;

import javax.management.MBeanServerConnection;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MBeanNameService extends AbstractService {

    public MBeanNameService(MBeanServerConnection serverConnection) {
        super(serverConnection);
    }

    public List<MBeanName> getMbeanNames(String domain) {
        String query = String.format("%s:*", domain);
        List<MBeanName> mBeanNames = new ArrayList<>();
        try {
            ObjectName objectName = new ObjectName(query);
            Set<ObjectInstance> objectInstances= this.getMbeanServerConnection().queryMBeans(objectName, null);
            mBeanNames = buildMBeanNames(objectInstances);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }

        return mBeanNames;
    }

    public MBeanName buildMbeanName(ObjectInstance instance) {
        MBeanName mBeanName = new MBeanName();
        mBeanName.setObjectName(instance.getObjectName().toString());
        mBeanName.setDomain(instance.getObjectName().getDomain());
        mBeanName.setProperties(MBeanName.buildPropsFromObjectName(instance.getObjectName().toString()));
        return mBeanName;
    }

    public List<MBeanName> buildMBeanNames(Set<ObjectInstance> objectInstances) {
        List<MBeanName> mBeanNames = new ArrayList<>();
        for(ObjectInstance instance: objectInstances) {
            mBeanNames.add(buildMbeanName(instance));
        }
        return mBeanNames;
    }
}
