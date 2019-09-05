package com.training.regform.controller;

import com.training.regform.controller.command.*;
import com.training.regform.controller.command.Exception;
import com.training.regform.model.entity.User;
import com.training.regform.model.service.TrainService;
import com.training.regform.model.service.UserService;

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
        commands.put("admin/userList", new UserList(new UserService()));
        commands.put("user/trainSelection", new TrainCommand(new TrainService()));
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
        System.out.println("path= " + path);


        Command command = commands.getOrDefault(path,
                (r) -> "/index.jsp)");
        String page = command.execute(request);
        if (path.contains("admin")){
            request.getRequestDispatcher("/WEB-INF/admin/userlist.jsp").forward(request, response);
            return;
        }
        if (path.contains("user")){
            request.getRequestDispatcher("/WEB-INF/user/trainselection.jsp").forward(request, response);
            return;
        }

        if (page.contains("redirect:")) {
            page = page.replace("redirect:", "/api");
            response.sendRedirect(page);
        } else{
            request.getRequestDispatcher(page).forward(request, response);
    }
}
}