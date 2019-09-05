package com.training.regform.controller.listener;

import com.training.regform.model.entity.User;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;


public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HashSet<String> loggedUsers = (HashSet<String>) httpSessionEvent
                .getSession().getServletContext()
                .getAttribute("loggedUsers");
        String username = ((User) httpSessionEvent.getSession().getAttribute("user")).getUsername();

        loggedUsers.remove(username);
        httpSessionEvent.getSession().setAttribute("loggedUsers", loggedUsers);
    }


}


