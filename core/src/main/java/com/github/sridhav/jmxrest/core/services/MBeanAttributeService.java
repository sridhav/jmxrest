package com.github.sridhav.jmxrest.core.services;

import com.github.sridhav.jmxrest.core.model.MBeanAttribute;
import com.github.sridhav.jmxrest.core.model.MBeanName;

import javax.management.MBeanAttributeInfo;
import javax.management.MBeanInfo;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MBeanAttributeService extends AbstractService{


    public MBeanAttributeService(MBeanServerConnection serverConnection) {
        super(serverConnection);
    }

    public List<MBeanAttribute> getMbeanValues(ObjectName objectName) {
        List<MBeanAttribute> mBeanAtrributes = new ArrayList<>();
        try {
            MBeanInfo mBeanInfo = this.getMbeanServerConnection().getMBeanInfo(objectName);
            mBeanAtrributes = buildMbeanAttributes(mBeanInfo.getAttributes(), objectName);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }

        return mBeanAtrributes;
    }

    public List<MBeanAttribute> getMbeanValues(String objectNameString) {
        List<MBeanAttribute> mBeanAtrributes = new ArrayList<>();
        try {
            ObjectName objectName = new ObjectName(objectNameString);
            mBeanAtrributes = this.getMbeanValues(objectName);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return mBeanAtrributes;
    }

    public List<MBeanAttribute> getMbeanValues(String domain, Properties properties) {
        String objectNameString = MBeanName.buildObjectName(domain, properties);
        return this.getMbeanValues(objectNameString);
    }

    public List<MBeanAttribute> buildMbeanAttributes(MBeanAttributeInfo[] mBeanAttributeInfos, ObjectName objectName){
        List<MBeanAttribute> mBeanAttributes = new ArrayList<>();
        try {
            for (MBeanAttributeInfo mBeanAttributeInfo: mBeanAttributeInfos) {
                mBeanAttributes.add(buildMbeanAttribute(mBeanAttributeInfo, objectName));
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return mBeanAttributes;
    }

    public MBeanAttribute buildMbeanAttribute(MBeanAttributeInfo mBeanAttributeInfo, ObjectName objectName) {
        MBeanAttribute attribute = new MBeanAttribute();
        attribute.setName(mBeanAttributeInfo.getName());
        attribute.setType(mBeanAttributeInfo.getType());
        try {
            attribute.setValue(this.getMbeanServerConnection().getAttribute(objectName, mBeanAttributeInfo.getName()));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }

        return attribute;
    }
}
