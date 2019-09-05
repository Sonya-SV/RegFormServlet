package com.training.regform.controller.command;

import com.training.regform.model.entity.User;
import com.training.regform.model.service.UserService;

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
        return "redirect:/app/admin/userList";
    }
}
