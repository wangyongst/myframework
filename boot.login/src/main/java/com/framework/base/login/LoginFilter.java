package com.framework.base.login;


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
    private String[] filters;
    private String redirect;

    public void init(FilterConfig filterConfig) throws ServletException {
        logger.debug("LoginFilter create!");
        this.filterConfig = filterConfig;
        if (nofilters == null) {
            Properties prop = new Properties();// 属性集合对象
            InputStream fis = this.getClass().getResourceAsStream("/properties/loginfilter.properties");// 属性文件输入流
            try {
                prop.load(fis);// 将属性文件流装载到Properties对象中
                fis.close();// 关闭流
            } catch (Exception e) {
                e.printStackTrace();
            }
            String nofilter = prop.getProperty("springmvc.nofilter");
            String filter = prop.getProperty("springmvc.filter");
            redirect = prop.getProperty("springmvc.redirect");
            nofilters = nofilter.split(",");
            filters = filter.split(",");
        }
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(true);
        String url = request.getRequestURI();
        boolean is = this.isProcesssed(url);
        boolean not = this.isUnprocesssed(url);
        if (is && !not) {
            logger.debug("LoginFilter processed:" + url);
            if (session.getAttribute("user") == null) {
                response.sendRedirect(request.getContextPath() + redirect);
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
            return;
        } else {
            logger.info("LoginFilter unprocessed:" + url);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
    }

    @Override
    public void destroy() {
        logger.debug("LoginFilter destroy!");
    }

    public boolean isUnprocesssed(String url) {
        for (String nf : nofilters) {
            if (StringUtils.isNotBlank(url) && url.contains(nf)) {
                return true;
            }
        }
        return false;
    }

    public boolean isProcesssed(String url) {
        for (String f : filters) {
            if (StringUtils.isNotBlank(url) && url.contains(f)) {
                return true;
            }
        }
        return false;
    }

}
