package com.training.regform.controller.command;

import com.training.regform.model.entity.User;
import com.training.regform.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Login implements Command {
//    private static final Logger logger = LogManager.getLogger(Login.class);
    private UserService userService;

    public Login(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        if (nonNull(request.getSession().getAttribute("user")))
            return "/index.jsp";

        String name = request.getParameter("username");
        String pass = request.getParameter("password");

        if (name == null || name.equals("") || pass == null || pass.equals("")) {
            return "/login.jsp";
        }

        Optional<User> user = userService.login(name, pass);
        if (user.isPresent()) {
            request.getSession().setAttribute("user", user.get());
            if (CommandUtility.checkUserIsLogged(request, name)) {
                return "/WEB-INF/error.jsp";
                //TODO rewrite
            }
            if (user.get().getRole().equals(User.Role.ADMIN)) {
                CommandUtility.setUserRole(request, User.Role.ADMIN, name);
                return "redirect:/app/admin/userList";
            } else if (user.get().getRole().equals(User.Role.USER)) {
                CommandUtility.setUserRole(request, User.Role.USER, name);
                return "redirect:/app/user/trainSelection";
            } else {
                CommandUtility.setUserRole(request, User.Role.GUEST, name);
                return "/login.jsp";
            }
        }
        return "/login.jsp";
    }
}
