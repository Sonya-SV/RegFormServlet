package com.training.regform.controller.command;

import com.training.regform.model.entity.Ticket;
import com.training.regform.model.entity.User;
import com.training.regform.model.service.TicketService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class HistoryCommand implements Command {
    private TicketService ticketService;

    public HistoryCommand(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        List<Ticket> tickets = ticketService.getAllTicketByUser((User)request.getSession().getAttribute("user"));
        request.getSession().setAttribute("tickets", tickets);
        return "app/user/history.jsp";
    }
}
