package com.tms;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Locale;

@WebFilter(value = "/*")
public class AccessFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String header = request.getHeader("parameter");
        String method = request.getMethod();

        if ("GET".equals(method.toUpperCase(Locale.ROOT))){
            filterChain.doFilter(servletRequest, servletResponse);
        } else{
            if (header == null){
                throw new AccessFilterException();
            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
