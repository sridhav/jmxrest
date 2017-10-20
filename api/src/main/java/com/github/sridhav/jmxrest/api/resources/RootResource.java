package com.github.sridhav.jmxrest.api.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by sridhav on 10/13/17.
 */

@Path("/")
public class RootResource {

    @GET
    public void get() {
        System.out.println("get");
    }
}
