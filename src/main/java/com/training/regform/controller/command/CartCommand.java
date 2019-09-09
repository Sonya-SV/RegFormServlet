package com.training.regform.controller.command;

import com.training.regform.model.entity.Ticket;
import com.training.regform.model.entity.Train;
import com.training.regform.model.entity.User;

import javax.servlet.http.HttpServletRequest;

public class CartCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {

        Ticket ticket = (Ticket) request.getSession().getAttribute("ticket");
        if(ticket == null){
            ticket = new Ticket();
            ticket.setTrain((Train)request.getSession().getAttribute("train"));
            ticket.setUser((User)request.getSession().getAttribute("user"));
            ticket.setFirstName(request.getParameter("firstName"));
            ticket.setLastName(request.getParameter("lastName"));
//            ticket.setTrain((Train) request.getSession().getAttribute("train"));
        }
        request.getSession().setAttribute("ticket", ticket);

//        request.getSession().setAttribute("user", request.getSession().getAttribute("user"));
        return "redirect:/app/user/cart";

    }
}
