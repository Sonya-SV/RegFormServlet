package com.training.regform.controller.filters;

import com.training.regform.model.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//TODO: add to web.xml
public class AccessFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String path = request.getRequestURI();
        if (path.contains("admin") && ((User) request.getSession().getAttribute("user")).getRole().equals(User.Role.ADMIN)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletResponse.getWriter().append("AccessDenied");
        }

    }


    @Override
    public void destroy() {

    }
}
