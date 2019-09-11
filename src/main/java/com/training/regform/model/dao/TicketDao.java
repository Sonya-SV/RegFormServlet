package com.training.regform.model.dao;

import com.training.regform.controller.exception.BalanceException;
import com.training.regform.controller.exception.NoSeatsException;
import com.training.regform.model.entity.Ticket;
import com.training.regform.model.entity.User;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public interface TicketDao extends GenericDao<Ticket> {
    public List<Ticket> findAllTicketsByUser(User user);
    void buyTheTicket(Ticket ticket, BigDecimal replenishment) throws BalanceException, SQLException, NoSeatsException;

}
