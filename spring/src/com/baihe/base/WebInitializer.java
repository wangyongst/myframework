package com.baihe.base;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.Log4jConfigListener;

@Order(1)
public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {

		servletContext.setInitParameter("log4jConfigLocation",
				"classpath:properties/log4j.properties");
		
		// 构建一个application context
	    AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
	    webContext.register(SpringConfig.class);
	    // 注册spring mvc 的 servlet
	    Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(webContext));
	    // 添加springMVC 允许访问的Controller后缀
	    dynamic.addMapping("*.do");
	    // 全部通过请用 “/”
	    // dynamic.addMapping(/);
	    //dynamic.setLoadOnStartup(2);
	
		servletContext.setInitParameter("webAppRootKey", "webapp.root.sm4.2");
		servletContext.addListener(Log4jConfigListener.class);
	}
}