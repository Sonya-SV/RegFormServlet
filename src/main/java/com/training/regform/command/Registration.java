package com.training.regform.command;

import com.training.regform.entity.User;
import com.training.regform.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class Registration implements Command {
    private UserService userService;

    public Registration(UserService userService) {
        this.userService = userService;
    }


    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("username");
        String pass = request.getParameter("password");

        if (name == null || name.equals("") || pass == null || pass.equals("")) {
            return "/registration.jsp";
        }
        User user = new User();
        user.setUsername(name);
        user.setPassword(pass);
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setRole(User.Role.USER);
        try {
            userService.saveUser(user);
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Not unique username");
            return "/registration.jsp";
        }
       return "redirect:/login.jsp";
    }
}
