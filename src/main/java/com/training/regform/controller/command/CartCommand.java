package com.training.regform.controller.command;

import com.training.regform.controller.exception.BalanceException;
import com.training.regform.controller.exception.NoSeatsException;
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

        User user = (User) request.getSession().getAttribute("user");

        if (ticket == null) {
            ticket = new Ticket();
            ticket.setTrain((Train) request.getSession().getAttribute("train"));
            ticket.setUser((User) request.getSession().getAttribute("user"));
            ticket.setFirstName(firstName);
            ticket.setLastName(lastName);
        }
        request.getSession().setAttribute("ticket", ticket);

    if(request.getParameter("pay")!=null) {
        try {
            ticketService.saveTicket(ticket);
            request.getSession().removeAttribute("ticket");
        } catch (BalanceException e) {
            System.out.println("errorPay");
            request.setAttribute("errorPay", ERROR_PAY);
            return "/app/user/cart";
        } catch (SQLException e) {
            //TODO redirect on error page with message
            System.out.println("can't save ticket");
            request.setAttribute("errorTicket", "Order failed. Please contact technical support.");
            return "/app/user/cart";
        } catch (NoSeatsException e) {
            System.out.println("errorSeats");
            request.setAttribute("errorSeats", "No such seats");
            return "/app/user/cart";
        }


        return "redirect:/app/user/history";
    }
    return "/app/user/cart";
    }
}
