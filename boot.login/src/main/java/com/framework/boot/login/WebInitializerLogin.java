package com.framework.boot.login;

import com.framework.boot.login.authimg.AuthImageServlet;
import com.framework.boot.login.filter.LoginFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import java.util.EnumSet;

@Order(5)
public class WebInitializerLogin implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext)
            throws ServletException {

        //LoginFilter
        LoginFilter loginFilter = new LoginFilter();
        FilterRegistration.Dynamic loginFilterRegistration = servletContext.addFilter("loginFilter", loginFilter);
        loginFilterRegistration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), false, "*.do", "*.jsp");

        //AuthImageServlet
        Dynamic authImageDynamic = servletContext.addServlet("AuthImageServlet", new AuthImageServlet());
        authImageDynamic.addMapping("/authImage.do");
    }
}