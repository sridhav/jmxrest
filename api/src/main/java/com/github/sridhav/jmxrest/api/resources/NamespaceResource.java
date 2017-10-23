package com.github.sridhav.jmxrest.api.resources;


import com.github.sridhav.jmxrest.api.JmxApplication;
import com.github.sridhav.jmxrest.api.dto.SuccessDto;
import com.github.sridhav.jmxrest.mybatis.dao.NamespaceService;
import com.github.sridhav.jmxrest.mybatis.entity.Namespace;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/namespaces")
public class NamespaceResource extends RootResource{

    private NamespaceService namespaceService = new NamespaceService();

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public SuccessDto createNamespace(Namespace namespace){
        if(namespaceService.createNamespace(namespace)) {
            JmxApplication.addToJmxServiceMap(namespace);
        }

        return getSuccess();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Namespace> getNamespaces() {
        return namespaceService.getNamespaces();
    }

    @GET
    @Path("/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public Namespace getNamespace(@PathParam("name") String name) {
        Namespace namespace = null;
        if (name != null) {
            namespace = namespaceService.getNamespaceByName(name);
        }
        return namespace;
    }
}
