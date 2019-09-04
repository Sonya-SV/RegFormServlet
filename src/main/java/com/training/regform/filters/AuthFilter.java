package com.training.regform.filters;

import com.training.regform.entity.User;
import com.training.regform.service.UserService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

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
//        System.out.println("role" + session.getAttribute("role"));
        System.out.println("loggedUsers " + context.getAttribute("loggedUsers"));

        filterChain.doFilter(request,response);

    }


    @Override
    public void destroy() {

    }
}
