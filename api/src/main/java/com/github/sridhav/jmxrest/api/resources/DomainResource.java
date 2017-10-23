package com.github.sridhav.jmxrest.api.resources;

import com.github.sridhav.jmxrest.api.JmxApplication;
import com.github.sridhav.jmxrest.api.dto.DomainDto;
import com.github.sridhav.jmxrest.api.dto.DomainListDto;
import com.github.sridhav.jmxrest.core.JmxService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/namespaces/{namespace}/domains")
public class DomainResource  extends RootResource{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public DomainListDto getDomains(final @PathParam("namespace") String namespace) {
        JmxService jmxService = JmxApplication.getJmxServiceMap().get(namespace);
        List<String> domains = jmxService.getDomains();
        return DomainListDto.convertToDomainListDto(domains, namespace);
    }

    @GET
    @Path("/{domain}")
    @Produces(MediaType.APPLICATION_JSON)
    public DomainDto getDomain(final @PathParam("namespace") String namespace, @PathParam("domain") String domain) {
        return DomainDto.convertTo(domain, namespace);
    }
}
