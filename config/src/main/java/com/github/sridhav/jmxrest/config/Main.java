package com.github.sridhav.jmxrest.config;

public class Main {

    public static void main(String args[]) {
        JmxProperties properties = JmxConfigurator.load(Main.class.getResource("/my.properties").getFile());
        System.out.println(properties);
    }
}
