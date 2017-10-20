package com.github.sridhav.jmxrest.mybatis.dao;

import com.github.sridhav.jmxrest.mybatis.MybatisService;
import org.apache.ibatis.session.SqlSession;

class DaoService {
    SqlSession sqlSession = MybatisService.getSqlSession();
}
