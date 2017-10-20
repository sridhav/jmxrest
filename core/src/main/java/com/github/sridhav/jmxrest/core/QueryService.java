package com.github.sridhav.jmxrest.core;

import com.github.sridhav.jmxrest.core.model.JmxBean;

import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

public class QueryService {

    private String query;

    private JmxBean jmxBean = null;


    public QueryService(String query) {
        this.setQuery(query);
        init();
    }

    private void init() {
        JmxBean jmxBean = new JmxBean();
        jmxBean.setName(this.getName());
        jmxBean.setType(this.getType());
        jmxBean.setDomain(this.getDomain());
        jmxBean.setKey(this.getAttributeKey());
        jmxBean.setObjectName(this.buildObjectName());
        this.setJmxBean(jmxBean);
    }

    public String getValue(MBeanServerConnection mBeanServerConnection) {
        String out = null;
        try {
            Object object = mBeanServerConnection.getAttribute(this.getJmxBean().getObjectName(), this.getJmxBean().getKey());
            out = object.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return out;
    }

    private String getName() {
        String name = null;
        if(this.validateQuery()) {
            String[] strings = this.getQuery().split(",");
            if (strings.length == 4){
                name = strings[3].split(":")[1];
            }
        }
        return name;
    }


    private String getType() {
        String type = null;
        if(this.validateQuery()) {
            String[] strings = this.getQuery().split(",");
            type = strings[1].split(":")[1];
        }
        return type;
    }

    private String getDomain() {
        String domain = null;
        if(this.validateQuery()) {
            String[] strings = this.getQuery().split(",");
            domain = strings[0].split(":")[1];
        }
        return domain;
    }

    private String getAttributeKey() {
        String attributeKey = null;
        if(this.validateQuery()) {
            String[] strings = this.getQuery().split(",");
            attributeKey = strings[2].split(":")[1];
        }
        return attributeKey;
    }
    private ObjectName buildObjectName() {
        String objectString = null;
        ObjectName objectName = null;
        if (this.validateQuery()){
            String[] strings = this.getQuery().split(",");

            if (strings.length == 3) {
                objectString = String.format("%s:type=%s",getDomain(), getType());
            }
            if(strings.length == 4) {
                objectString =String.format("%s,name=%s", getName());
            }
            try {
                objectName = new ObjectName(objectString);
            } catch (MalformedObjectNameException e) {
                e.printStackTrace();
            }
        }

        return objectName;
    }


    private boolean validateQuery() {
        boolean ret = false;
        if (this.getQuery()!=null && !this.getQuery().isEmpty()) {
            ret = this.getQuery().matches("^d:[a-zA-Z_0-9 .]+,t:[a-zA-Z_0-9 .]+,a:[a-zA-Z_0-9 .]+(,n:[a-zA-Z_0-9 .]+)?$");
        }

        return ret;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public JmxBean getJmxBean() {
        return jmxBean;
    }

    public void setJmxBean(JmxBean jmxBean) {
        this.jmxBean = jmxBean;
    }

    public JmxBean getJmxBeanWithValue(MBeanServerConnection mBeanServerConnection) {
        this.jmxBean.setValue(this.getValue(mBeanServerConnection));
        return this.jmxBean;
    }
}
