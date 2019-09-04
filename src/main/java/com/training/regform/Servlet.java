package com.training.regform;

import com.training.regform.command.*;
import com.training.regform.command.Exception;
import com.training.regform.entity.User;
import com.training.regform.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Servlet extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();

    public void init(ServletConfig servletConfig) {
        servletConfig.getServletContext()
                .setAttribute("loggedUsers", new HashSet<String>());

        commands.put("logout", new LogOut());
        commands.put("login", new Login(new UserService()));
        commands.put("registration", new Registration(new UserService()));
        commands.put("exception", new Exception());
        commands.put("userList", new UserList(new UserService()));
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        System.out.println(path);
        path = path.replaceAll(".*/app/", "");
        System.out.println(path);
        Command command = commands.getOrDefault(path,
                (r) -> "/index.jsp)");
        String page = command.execute(request);
        if (page.contains("redirect:")) {
            response.sendRedirect(page.replace("redirect:", "/api"));
        } else{
            request.getRequestDispatcher(page).forward(request, response);
    }
}
}