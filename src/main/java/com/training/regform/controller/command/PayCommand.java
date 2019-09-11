package com.training.regform.controller.command;

import com.training.regform.controller.exception.BalanceException;
import com.training.regform.controller.exception.NoSeatsException;
import com.training.regform.model.entity.Ticket;
import com.training.regform.model.service.TicketService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class PayCommand implements Command {
    public final static String ERROR_PAY = "Not enough money in the account";

    private TicketService ticketService;

    public PayCommand(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        Ticket ticket = (Ticket) request.getSession().getAttribute("ticket");
        try {
            ticketService.saveTicket(ticket);
        } catch (BalanceException e) {
            System.out.println("errorPay");
            request.setAttribute("errorPay", ERROR_PAY);
            return "redirect:/app/user/cart";
        } catch (SQLException e) {
            //TODO redirect on error page with message
            System.out.println("can't save ticket");
            request.setAttribute("errorTicket", "Order failed. Please contact technical support.");
            return "redirect:/app/user/cart";
        } catch (NoSeatsException e) {
            System.out.println("errorSeats");
            request.setAttribute("errorSeats", "No such seats");
            return "redirect:/app/user/cart";
        }
        return "redirect:/app/user/history";
    }
}
