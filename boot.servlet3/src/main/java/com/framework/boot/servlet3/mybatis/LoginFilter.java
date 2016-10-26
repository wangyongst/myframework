package com.framework.boot.servlet3.mybatis;


import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by BHWL on 2016-04-27.
 */
public class LoginFilter implements Filter {

    private static final Logger logger = LogManager.getLogger(LoginFilter.class);

    private FilterConfig filterConfig;

    private String[] nofilters;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        if (nofilters == null) {
            Properties prop = new Properties();// 属性集合对象
            InputStream fis = this.getClass().getResourceAsStream("/properties/springmvc.properties");// 属性文件输入流
            try {
                prop.load(fis);// 将属性文件流装载到Properties对象中
                fis.close();// 关闭流
            } catch (Exception e) {
                e.printStackTrace();
            }
            String nofilter = prop.getProperty("springmvc.nofilter");
            nofilters = nofilter.split(",");
        }
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("LoginFilter create!");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(true);
        String url = request.getRequestURI();
        logger.info("LoginFilter URL is:"+url);
        for (String nf : nofilters) {
            if (StringUtils.isNotBlank(url) && url.contains(nf)) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }
        if (session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

}
