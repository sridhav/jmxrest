package com.github.sridhav.jmxrest.core;

public class CoreUtils {

    public final static String TEMPLATE_JMX_BEAN_NAME = "d:%s,t:%s,a:%s,n:%s";

    public final static String TEMPLATE_JMX_BEAN = "d:%s,t:%s,a:%s";


    public static boolean isNullOrEmpty(String string) {
        boolean ret = false;
        if (string == null || string.isEmpty()) {
            ret = true;
        }
        return ret;
    }

    public static boolean validateObjectName(String objectname) {
        boolean ret = false;
        if (!isNullOrEmpty(objectname)) {
            ret = objectname.matches("^[a-zA-Z0-9 .]+:type=[a-zA-Z0-9 _]+(,name=[a-zA-Z0-9 _]+)?$");
        }
        return ret;
    }

    public static String convertObjectNameToQuery(String objectName, String attribute) {
        String query = null;
        if (validateObjectName(objectName)) {
            String domain, type, name;
            String[] firstSplit = objectName.split(",");
            if (firstSplit.length > 0) {
                domain = firstSplit[0].split(":")[0];
                type = firstSplit[0].split(":")[1].split("=")[1];
                query = String.format("d:%s,t:%s,a:%s", domain, type, attribute);
                if (firstSplit.length == 2) {
                    name = firstSplit[0].split("=")[1];
                    query = String.format("%s,n:%s", query, name);
                }
            }
        }
        return query;
    }
}
