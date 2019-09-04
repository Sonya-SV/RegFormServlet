package com.training.regform.command;

import com.training.regform.entity.User;
import com.training.regform.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserList implements Command {

    private UserService userService;

    public UserList(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        List<User> users = userService.getAllUsers();
        request.setAttribute("users", users);
        return "/WEB-INF/userlist.jsp";
    }
}
