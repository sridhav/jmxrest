package com.github.sridhav.jmxrest.api.resources;

import com.github.sridhav.jmxrest.api.JmxApplication;
import com.github.sridhav.jmxrest.core.JmxService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Map;

/**
 * Created by sridhav on 10/13/17.
 */

@Path("/")
public class RootResource extends AbstractResource{

    @GET
    public void get() {
        System.out.println("get");
    }
}
