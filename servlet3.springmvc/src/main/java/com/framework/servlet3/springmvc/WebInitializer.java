package com.framework.servlet3.springmvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.Log4jConfigListener;

@Order(4)
public class WebInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext)
			throws ServletException {

		servletContext.setInitParameter("log4jConfigLocation",
				"classpath:properties/log4j.properties");

		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(SpringMvcConfig.class);
		Dynamic dynamic = servletContext.addServlet("dispatcher",
				new DispatcherServlet(webContext));
		dynamic.addMapping("*.do");
		dynamic.setLoadOnStartup(1);

		servletContext.addListener(Log4jConfigListener.class);
	}
}