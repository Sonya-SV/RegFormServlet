package com.training.regform.model.dao.impl;

import com.training.regform.controller.exception.BalanceException;
import com.training.regform.controller.exception.NoSeatsException;
import com.training.regform.model.dao.TicketDao;
import com.training.regform.model.entity.Ticket;
import com.training.regform.model.entity.User;
import com.training.regform.model.mapper.RouteMapper;
import com.training.regform.model.mapper.TicketMapper;
import com.training.regform.model.mapper.TrainMapper;
import com.training.regform.model.mapper.UserMapper;

import java.math.BigDecimal;
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
    public void buyTheTicket(Ticket ticket, BigDecimal replenishment) throws BalanceException, SQLException, NoSeatsException {


        final String queryForUser = "UPDATE user SET balance = ? WHERE id = ?";
        final String queryForTicket = "insert into ticket(first_name, last_name, train_id, user_id) values (?,?,?,?)";
        final String queryForTrain = "UPDATE train SET free_seats = ? WHERE id = ?";
        try (PreparedStatement stUser = connection.prepareStatement(queryForUser);
             PreparedStatement stTicket = connection.prepareStatement(queryForTicket);
             PreparedStatement stTrain = connection.prepareStatement(queryForTrain)) {

            connection.setAutoCommit(false);

            if (ticket.getTrain().getFreeSeats() <= 0)
                throw new NoSeatsException();
            if (ticket.getUser().getBalance().compareTo(replenishment) < 0)
                throw new BalanceException();


            ticket.getTrain().setFreeSeats(ticket.getTrain().getFreeSeats() - 1);
            stTrain.setInt(1, ticket.getTrain().getFreeSeats());
            stTrain.setLong(2, ticket.getTrain().getId());
            stTrain.execute();

            ticket.getUser().setBalance(ticket.getUser().getBalance().subtract(replenishment));
            stUser.setBigDecimal(1, ticket.getUser().getBalance());
            stUser.setLong(2, ticket.getUser().getId());

            stTicket.setString(1, ticket.getFirstName());
            stTicket.setString(2, ticket.getLastName());
            stTicket.setLong(3, ticket.getTrain().getId());
            stTicket.setLong(4, ticket.getUser().getId());

            stTrain.execute();
            stUser.execute();
            stTicket.execute();

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


    }

    @Override
    public List<Ticket> findAllTicketsByUser(User user) {
        Map<Long, Ticket> tickets = new HashMap<>();
        final String query = "select * from ticket inner join train " +
                "on train_id = train.id inner join route " +
                "on route_id = route.id  inner join user u " +
                "on user_id = u.id where user_id = ?";
//                "order by ticket.id desc";
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setLong(1, user.getId());
            TicketMapper ticketMapper = new TicketMapper(new TrainMapper(new RouteMapper()), new UserMapper());

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
//        final String query = "insert into ticket(first_name, last_name, train_id, user_id) values (?,?,?,?)";
//        try (PreparedStatement st = connection.prepareStatement(query)) {
//            st.setString (1, entity.getFirstName());
//            st.setString   (2, entity.getLastName());
//            st.setLong(3, entity.getTrain().getId());
//            st.setLong(4, entity.getUser().getId());
//            st.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new SQLException();
//        }
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
