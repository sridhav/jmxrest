package com.github.sridhav.jmxrest.api;


import com.github.sridhav.jmxrest.config.JmxConfigurator;
import com.github.sridhav.jmxrest.core.JmxService;
import com.github.sridhav.jmxrest.mybatis.MybatisService;
import org.apache.log4j.PropertyConfigurator;

import java.util.Map;

/**
 * Created by sridhav on 10/14/17.
 */
public class JmxRestMain extends JmxApplication{

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: JmxRestMain config.properties");
            System.exit(1);
        }

        JmxConfigurator.load(args[0]);
        PropertyConfigurator.configure(JmxConfigurator.getLogProperties());
        MybatisService.init(JmxConfigurator.getMyBatisProperties());
        JmxApplication jmxApplication = new JmxApplication();
        jmxApplication.start();
    }


}
