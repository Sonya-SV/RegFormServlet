package com.training.regform.controller.command;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.training.regform.model.entity.User;
import java.util.HashSet;

class CommandUtility {
    static void setUserRole(HttpServletRequest request,
                            User.Role role, String name) {
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();
        context.setAttribute("username", name);
        session.setAttribute("role", role);

    }

    static boolean checkUserIsLogged(HttpServletRequest request, String username){
        HashSet<String> loggedUsers = (HashSet<String>) request.getSession().getServletContext()
                .getAttribute("loggedUsers");

        if(!loggedUsers.isEmpty()
                && loggedUsers.stream().anyMatch(username::equals)){
            return true;
        }

        loggedUsers.add(username);
        request.getSession().getServletContext()
                .setAttribute("loggedUsers", loggedUsers);

        return false;
    }
}
