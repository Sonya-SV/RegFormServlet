package com.training.regform.model.service;

import com.training.regform.controller.exception.BalanceException;
import com.training.regform.controller.exception.NoSeatsException;
import com.training.regform.model.dao.DaoFactory;
import com.training.regform.model.dao.TicketDao;
import com.training.regform.model.entity.Ticket;
import com.training.regform.model.entity.User;

import java.sql.SQLException;
import java.util.List;

public class TicketService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Ticket> getAllTicketByUser(User user){
        try (TicketDao dao = daoFactory.createTicketDao()) {
            return dao.findAllTicketsByUser(user);
        }
    }
    public void saveTicket(Ticket ticket) throws SQLException, BalanceException, NoSeatsException {
        try (TicketDao dao = daoFactory.createTicketDao()) {
            dao.buyTheTicket(ticket, ticket.getTrain().getPrice());
        }
    }
}
