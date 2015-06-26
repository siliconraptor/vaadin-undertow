package com.sraptors;

import static io.undertow.servlet.Servlets.defaultContainer;
import static io.undertow.servlet.Servlets.deployment;
import static io.undertow.servlet.Servlets.servlet;
import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.handlers.PathHandler;
import io.undertow.server.handlers.resource.FileResourceManager;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;

import java.io.File;

import javax.servlet.ServletException;

import com.sraptors.VaadinWebUI.MyServlet;

public class App {
	
	public static final String MYAPP = "/vaadin-undertow";
	public static boolean STAY_ALIVE = true;

	public static void main(String[] args) {
		try{
			
			DeploymentInfo servletBuilder = deployment()
	                .setClassLoader(App.class.getClassLoader())
	                .setContextPath(MYAPP)
	                .setDeploymentName("vaadin.war")
	                .setResourceManager(new FileResourceManager(new File("src/main/webapp"), 1024))
	                .addServlets(
	                        servlet("MyVaadinServlet", MyServlet.class)
	                                .addInitParam("message", "Hello Vaadin and Undertow!!!")
	                                .addMapping("/*"));
	
	        DeploymentManager manager = defaultContainer().addDeployment(servletBuilder);
	        manager.deploy();
	
	        HttpHandler servletHandler = manager.start();
	        PathHandler path = Handlers.path(Handlers.redirect(MYAPP))
	                .addPrefixPath(MYAPP, servletHandler);
	        Undertow server = Undertow.builder()
	                .addHttpListener(8080, "localhost")
	                .setHandler(path)
	                .build();
	        server.start();
	        
	        while(STAY_ALIVE){
	        	//stay alive
	        }
	    } catch (ServletException e) {
	        throw new RuntimeException(e);
	    }
	}
}
    

