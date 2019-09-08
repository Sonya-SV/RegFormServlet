package com.training.regform.controller.command;

import com.training.regform.model.entity.Ticket;
import com.training.regform.model.entity.Train;
import com.training.regform.model.entity.User;

import javax.servlet.http.HttpServletRequest;

public class CartCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        Ticket ticket = (Ticket) request.getSession().getAttribute("ticket");

        request.getSession().setAttribute("ticket", ticket);

        return "redirect:/app/user/cart";

    }
}
