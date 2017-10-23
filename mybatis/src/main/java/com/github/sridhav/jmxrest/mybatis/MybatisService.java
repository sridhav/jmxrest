package com.github.sridhav.jmxrest.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MybatisService {

    private static SqlSessionFactory sqlSessionFactory = null;

    private static String defaultResource = "mybatis-config.xml";

    private static Logger LOGGER = Logger.getLogger(MybatisService.class);

    public static void init(Properties properties, String resource) {
        try {
            if (sqlSessionFactory == null) {
                InputStream inputStream = new FileInputStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

    public static void init(Properties properties) {
        try {
            String resource = Resources.getResourceAsFile(defaultResource).getAbsolutePath();
            init(properties, resource);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public static void init() {
        init(new Properties());
    }

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession(true);
    }
}
