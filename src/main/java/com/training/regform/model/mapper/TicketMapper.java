package com.training.regform.model.mapper;

import com.training.regform.model.entity.Ticket;
import com.training.regform.model.entity.Train;
import com.training.regform.model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketMapper implements ObjectMapper<Ticket>{
    @Override
    public Ticket extractFromResultSet(ResultSet rs) throws SQLException {
        Ticket ticket = new Ticket();
        ticket.setId(rs.getLong("id"));
        ticket.setFirstName(rs.getString("first_name"));
        ticket.setLastName(rs.getString("last_name"));
        ticket.setTrain((Train)rs.getObject("train_id"));
        ticket.setUser((User)rs.getObject("user_id"));
        return ticket;
    }
}
