package com.framework.boot.servlet3;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.Log4jConfigListener;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import java.util.EnumSet;

@Order(4)
public class WebInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext)
            throws ServletException {

        servletContext.setInitParameter("log4jConfigLocation", "classpath:properties/log4j.properties");

        //加载Spring配置
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(SpringConfig.class);
        Dynamic dispatcherDynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(webContext));
        dispatcherDynamic.addMapping("*.do");
        dispatcherDynamic.setLoadOnStartup(1);

        //LoginFilter
        LoginFilter loginFilter = new LoginFilter();
        FilterRegistration.Dynamic loginFilterRegistration = servletContext.addFilter("loginFilter", loginFilter);
        loginFilterRegistration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), false, "*.do", "*.jsp");

        //HiddenHttpMethodFilter
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        FilterRegistration.Dynamic hiddenHttpMethodFilterRegistration = servletContext.addFilter("hiddenHttpMethodFilter", hiddenHttpMethodFilter);
        hiddenHttpMethodFilterRegistration.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), false, "dispatcher");

        //CharacterEncodingFilter
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("utf-8");
        encodingFilter.setForceEncoding(true);
        FilterRegistration.Dynamic encodingFilterRegistration = servletContext.addFilter("encodingFilter", encodingFilter);
        encodingFilterRegistration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), false, "/*");

        //Log4jConfigListener
        servletContext.addListener(Log4jConfigListener.class);

        //AuthImageServlet
        Dynamic authImageDynamic = servletContext.addServlet("AuthImageServlet",new AuthImageServlet());
        authImageDynamic.addMapping("/authImage.do");
    }
}