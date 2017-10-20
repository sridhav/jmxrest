package com.github.sridhav.jmxrest.api.resources;



import com.github.sridhav.jmxrest.mybatis.mapper.UserMapper;
import com.github.sridhav.jmxrest.mybatis.MybatisService;
import com.github.sridhav.jmxrest.mybatis.entity.User;
import org.apache.ibatis.session.SqlSession;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by sridhav on 10/14/17.
 */
@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {
    private static final String TEMPLATE = "Hello, %s!";

    @GET
    public String sayHello() {
        SqlSession sqlSession = MybatisService.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user= new User();
        user.setEmail("abc@gmail.com");
        user.setPwd("password");
        user.setUserName("abc2");
        mapper.insert(user);
        return "true";
    }
}
