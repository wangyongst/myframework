package com.framework.boot.servlet3.mybatis;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.Log4jConfigListener;

import java.util.EnumSet;

@Order(4)
public class WebInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext)
            throws ServletException {

        servletContext.setInitParameter("log4jConfigLocation",
                "classpath:properties/log4j.properties");

        LoginFilter loginFilter = new LoginFilter();
        FilterRegistration.Dynamic filterRegistration = servletContext.addFilter(
                "loginFilter", loginFilter);
        filterRegistration.addMappingForUrlPatterns(
                EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), false, "*.do", "*.jsp");

        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(SpringMvcConfig.class);
        Dynamic dynamic = servletContext.addServlet("dispatcher",
                new DispatcherServlet(webContext));
        dynamic.addMapping("*.do");
        dynamic.setLoadOnStartup(1);

        servletContext.addListener(Log4jConfigListener.class);
    }
}