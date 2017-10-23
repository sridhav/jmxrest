package com.github.sridhav.jmxrest.core.services;



import com.github.sridhav.jmxrest.core.model.MBean;
import com.github.sridhav.jmxrest.core.model.MBeanAttribute;
import com.github.sridhav.jmxrest.core.model.MBeanName;

import javax.management.MBeanServerConnection;
import java.util.ArrayList;
import java.util.List;

public class MBeanService extends AbstractService {
    private MBeanAttributeService mBeanAttributeService = null;

    private MBeanNameService mBeanNameService = null;

    public MBeanService(MBeanServerConnection serverConnection) {
        super(serverConnection);
        init();
    }

    private void init() {
        this.setmBeanAttributeService(new MBeanAttributeService(this.getMbeanServerConnection()));
        this.setmBeanNameService(new MBeanNameService(this.getMbeanServerConnection()));
    }

    public List<MBean> getAllMbeans(String domain) {
        List<MBean> mBeans = new ArrayList<>();
        List<MBeanName> mBeanNames = this.getmBeanNameService().getMbeanNames(domain);
        for (MBeanName mBeanName: mBeanNames) {
            MBean mBean = new MBean();
            List<MBeanAttribute> mBeanAttributes = this.getmBeanAttributeService().getMbeanValues(mBeanName.getObjectName());
            mBean.setmBeanName(mBeanName);
            mBean.setmBeanAttribute(mBeanAttributes);
            mBeans.add(mBean);
        }
        return mBeans;
    }


    public MBeanAttributeService getmBeanAttributeService() {
        return mBeanAttributeService;
    }

    public void setmBeanAttributeService(MBeanAttributeService mBeanAttributeService) {
        this.mBeanAttributeService = mBeanAttributeService;
    }

    public MBeanNameService getmBeanNameService() {
        return mBeanNameService;
    }

    public void setmBeanNameService(MBeanNameService mBeanNameService) {
        this.mBeanNameService = mBeanNameService;
    }

}
