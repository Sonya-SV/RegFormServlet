package com.training.regform.controller.command;

import com.training.regform.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogOut implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        final HttpSession session = request.getSession();
//        session.getServletContext().removeAttribute("role");
        session.invalidate();
        CommandUtility.setUserRole(request, User.Role.GUEST, "Guest");
        return "redirect:/index.jsp";
    }
}
