package com.entertainment.test.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/*", filterName = "contextFilter")  //这里的“/*” 表示的是需要拦截的请求路径
public class ContextFilter implements Filter {
    @Value("${cross.name}")
    private String crossName;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        httpServletRequest.getSession();
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        httpResponse.setHeader("Access-Control-Allow-Origin", crossName);
        httpResponse.setHeader("Access-Control-Allow-Methods", "*");
        httpResponse.setHeader("Access-Control-Max-Age", "3600");
        httpResponse.setHeader("Access-Control-Allow-Headers","*");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
//        httpResponse.setHeader("Content-type", "application/json");
//        httpResponse.setHeader("Cache-Control", "no-cache, must-revalidate");
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            return ;
        }
        filterChain.doFilter(httpServletRequest, httpResponse);

    }

    @Override
    public void destroy() {

    }
}
