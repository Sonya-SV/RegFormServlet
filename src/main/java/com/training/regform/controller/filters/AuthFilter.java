package com.training.regform.controller.filters;

import com.training.regform.model.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.TimeZone;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {



        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        ServletContext context = request.getServletContext();
//        System.out.println(session);
        if(session.getAttribute("role")==null)
            session.setAttribute("role", User.Role.GUEST);
//        System.out.println("role" + session.getAttribute("role"));
        System.out.println("loggedUsers " + context.getAttribute("loggedUsers"));

        filterChain.doFilter(request,response);

    }


    @Override
    public void destroy() {

    }
}
