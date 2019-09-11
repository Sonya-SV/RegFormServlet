package com.training.regform.controller.command;

import com.training.regform.controller.exception.BalanceException;
import com.training.regform.model.entity.Ticket;
import com.training.regform.model.entity.Train;
import com.training.regform.model.entity.User;
import com.training.regform.model.service.TicketService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CartCommand implements Command {
    public final static String ERROR_PAY = "Not enough money in the account";
    public final static String EMPTY_CART = "Cart is empty";

    private TicketService ticketService;

    public CartCommand(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        Ticket ticket = (Ticket) request.getSession().getAttribute("ticket");
        if(ticket == null)
            request.setAttribute("emptyCart", EMPTY_CART);
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

//        User user = (User) request.getSession().getAttribute("user");

        if (ticket == null) {
            ticket = new Ticket();
            ticket.setTrain((Train) request.getSession().getAttribute("train"));
            ticket.setUser((User) request.getSession().getAttribute("user"));
            ticket.setFirstName(firstName);
            ticket.setLastName(lastName);
        }
        request.getSession().setAttribute("ticket", ticket);


        try {
            ticketService.saveTicket(ticket);
        } catch (BalanceException e) {
            request.setAttribute("errorPay", ERROR_PAY);
            return "/app/user/cart.jsp";
        } catch (SQLException e) {
            //TODO redirect on error page with message
            System.out.println("can't save ticket");
            request.setAttribute("errorTicket", "Order failed. Please contact technical support.");
//            return"/app/user/error.jsp";
        }
//        request.getSession().removeAttribute("ticket");
        return "redirect:/app/user/history.jsp";
    }
}
