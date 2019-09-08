package com.training.regform.model.dao.impl;

import com.training.regform.model.dao.TicketDao;
import com.training.regform.model.entity.Ticket;
import com.training.regform.model.entity.Train;
import com.training.regform.model.entity.User;
import com.training.regform.model.mapper.TicketMapper;
import com.training.regform.model.mapper.UserMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class JDBCTicketDao implements TicketDao {

    private Connection connection;

    public JDBCTicketDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Ticket> findAllTicketsByUser(User user) {
        Map<Long, Ticket> tickets = new HashMap<>();
        final String query = "select * from ticket where user_id = ?";
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setLong (1, user.getId());
            TicketMapper ticketMapper = new TicketMapper();

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Ticket ticket = ticketMapper.extractFromResultSet(rs);
                tickets.putIfAbsent(ticket.getId(), ticket);
            }
            return new ArrayList<>(tickets.values());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void create(Ticket entity) throws SQLException {
        final String query = "insert into ticket(first_name, last_name, train_id, user_id) values (?,?,?,?)";
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setString (1, entity.getFirstName());
            st.setString   (2, entity.getLastName());
            st.setLong(3, entity.getTrain().getId());
            st.setLong(4, entity.getUser().getId());
            st.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        return null;
    }

    @Override
    public List<Ticket> findAll() {
        return null;
    }

    @Override
    public void update(Ticket entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }
}
