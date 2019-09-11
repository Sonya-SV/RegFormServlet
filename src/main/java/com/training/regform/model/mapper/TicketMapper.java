package com.training.regform.model.mapper;

import com.training.regform.model.entity.Ticket;
import com.training.regform.model.entity.Train;
import com.training.regform.model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketMapper implements ObjectMapper<Ticket>{
    private TrainMapper trainMapper;
    private UserMapper userMapper;

    public TicketMapper(TrainMapper trainMapper, UserMapper userMapper) {
        this.trainMapper = trainMapper;
        this.userMapper = userMapper;
    }

    @Override
    public Ticket extractFromResultSet(ResultSet rs) throws SQLException {
        Ticket ticket = new Ticket();
        ticket.setId(rs.getLong("id"));
        ticket.setFirstName(rs.getString("first_name"));
        ticket.setLastName(rs.getString("last_name"));
        ticket.setTrain(trainMapper.extractFromResultSet(rs));
        ticket.setUser(userMapper.extractFromResultSet(rs));
        return ticket;
    }
}
