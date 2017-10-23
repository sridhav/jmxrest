package com.github.sridhav.jmxrest.core.model;

import java.util.List;

public class MBean {

    private MBeanName mBeanName;

    private List<MBeanAttribute> mBeanAttribute;

    public MBeanName getmBeanName() {
        return mBeanName;
    }

    public void setmBeanName(MBeanName mBeanName) {
        this.mBeanName = mBeanName;
    }

    public List<MBeanAttribute> getmBeanAttribute() {
        return mBeanAttribute;
    }

    public void setmBeanAttribute(List<MBeanAttribute> mBeanAttribute) {
        this.mBeanAttribute = mBeanAttribute;
    }
}
