package com.sraptors;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *
 */
@Theme("mytheme")
@Widgetset("com.sraptors.MyAppWidgetset")
public class VaadinWebUI extends UI {
	


    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        
        Label Introductionlabel = new Label("Welcome to Vaadin, riding on Undertow!");
        layout.addComponent(Introductionlabel);
        
        Link link = new Link("Learn more about Vaadin here...",
                new ExternalResource("http://demo.vaadin.com/book-examples-vaadin7/book/#intro.walkthrough.helloworld"));
        layout.addComponent(link);
        
        
    }

    @WebServlet(urlPatterns = "/*", name = "MyVaadinServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = VaadinWebUI.class, productionMode = false)
    public static class MyServlet extends VaadinServlet {
    }
}
