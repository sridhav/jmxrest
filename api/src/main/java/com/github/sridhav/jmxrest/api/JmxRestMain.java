package com.github.sridhav.jmxrest.api;


import com.github.sridhav.jmxrest.mybatis.MybatisService;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by sridhav on 10/14/17.
 */
public class JmxRestMain extends JmxApplication{
    static {
        PropertyConfigurator.configure(JmxRestMain.class.getResource("/log4j.properties").getFile());
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: JmxRestMain config.properties");
            System.exit(1);
        }
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(args[0]));
            MybatisService.init(properties);
            JmxApplication jmxApplication = new JmxApplication();
            jmxApplication.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
