package com.github.sridhav.jmxrest.api;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Slf4jRequestLog;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.RequestLogHandler;
import org.eclipse.jetty.server.handler.StatisticsHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;


import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by sridhav on 10/14/17.
 */
public class JmxApplication {

    private Server server = null;

     JmxApplication() {
        this.server = createServer();
    }

    private Server createServer() {
        Server server = new Server(8082);

        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        servletContextHandler.setContextPath("/");

        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(JacksonFeature.class);
        resourceConfig.packages("com.github.sridhav.jmxrest.api.resources");
        ServletContainer servletContainer = new ServletContainer(resourceConfig);
        ServletHolder defaultHolder = new ServletHolder(servletContainer);
        defaultHolder.setInitParameter("dirAllowed", "false");
        defaultHolder.setInitOrder(1);
        servletContextHandler.addServlet(defaultHolder, "/*");

        RequestLogHandler requestLogHandler = new RequestLogHandler();
        Slf4jRequestLog requestLog = new Slf4jRequestLog();
        requestLog.setLoggerName("sample");
        requestLog.setLogLatency(true);
        requestLogHandler.setRequestLog(requestLog);

        HandlerCollection handlers = new HandlerCollection();
        handlers.setHandlers(new Handler[]{servletContextHandler, new DefaultHandler(), requestLogHandler});

    /* Needed for graceful shutdown as per `setStopTimeout` documentation */
        StatisticsHandler statsHandler = new StatisticsHandler();
        statsHandler.setHandler(handlers);
        server.setHandler(statsHandler);
        server.setStopAtShutdown(true);


        return server;
    }


    protected void start() {
        try {
            if(this.server != null) {
                server.start();
                server.join();
            }
        }  catch (Exception e) {
            this.stop();
            Logger.getLogger(JmxApplication.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            server.destroy();
        }
    }

    protected void stop() {
        try {
            server.stop();
        } catch (Exception e) {
            Logger.getLogger(JmxApplication.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
