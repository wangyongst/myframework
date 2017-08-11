package com.framework.boot.login.filter;


import com.framework.utils.Props;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
            Props props = new Props("application.properties");
            String nofilter = props.getStr("custom.loginFilter.nofilter");
            String filter = props.getStr("custom.loginFilter.filter");
            redirect = props.getStr("custom.loginFilter.redirect");
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
