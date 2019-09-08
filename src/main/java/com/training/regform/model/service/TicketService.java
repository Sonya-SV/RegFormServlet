package com.training.regform.model.service;

import com.training.regform.model.dao.DaoFactory;
import com.training.regform.model.dao.TicketDao;
import com.training.regform.model.dao.TrainDao;
import com.training.regform.model.entity.Ticket;
import com.training.regform.model.entity.Train;
import com.training.regform.model.entity.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class TicketService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Ticket> getAllTicketByUser(User user){
        try (TicketDao dao = daoFactory.createTicketDao()) {
            return dao.findAllTicketsByUser(user);
        }
    }
}
