package org.courses.web;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by dleb on 03/21/2019.
 */

public class Program implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringConfig.class);
        context.refresh();

        servletContext.addListener(new ContextLoaderListener(context));

        ServletRegistration.Dynamic cxfRegistration = servletContext.addServlet("dispatcher", new CXFServlet());
        cxfRegistration.setLoadOnStartup(1);
        cxfRegistration.addMapping("/services/*");

        ServletRegistration.Dynamic dispatcherRegistration = servletContext.addServlet("app", new DispatcherServlet(context));
        dispatcherRegistration.setLoadOnStartup(1);
        dispatcherRegistration.addMapping("/rest/*");
    }
}
