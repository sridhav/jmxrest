package com.github.sridhav.jmxrest.mybatis.dao;

import com.github.sridhav.jmxrest.mybatis.entity.NamespaceExample;
import com.github.sridhav.jmxrest.mybatis.mapper.NamespaceMapper;
import com.github.sridhav.jmxrest.mybatis.entity.Namespace;

import java.util.List;

public class NamespaceService extends DaoService{

    private NamespaceMapper mapper = sqlSession.getMapper(NamespaceMapper.class);

    private NamespaceExample namespaceExample = new NamespaceExample();

    public void createNamespace(Namespace namespace) {
        mapper.insert(namespace);
    }

    public Namespace getNamespaceByName(String name){
        namespaceExample.createCriteria().andNameEqualTo(name);
        List<Namespace> records = mapper.selectByExample(namespaceExample);
        Namespace namespace = null;
        if (records.size() >= 1) {
            namespace = records.get(0);
        }
        return namespace;
    }

    public List<Namespace> getNamespaces() {
        List<Namespace> namespaces = mapper.selectByExample(null);
        return namespaces;
    }
}
