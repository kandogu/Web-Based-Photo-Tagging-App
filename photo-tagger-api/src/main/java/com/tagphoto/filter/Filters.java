package com.tagphoto.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class Filters implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.addHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        httpServletResponse.addHeader("dogukan", "123");
        chain.doFilter(request, httpServletResponse);
    }
}
