package com.training.regform.model.dao.impl;

import com.training.regform.model.dao.TrainDao;
import com.training.regform.model.entity.Route;
import com.training.regform.model.entity.Train;
import com.training.regform.model.mapper.RouteMapper;
import com.training.regform.model.mapper.TrainMapper;
import com.training.regform.model.mapper.UserMapper;

import javax.swing.text.html.Option;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class JDBCTrainDao implements TrainDao {
    private Connection connection;

    public JDBCTrainDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Train> findByRouteAndDateAndTime(LocalDate date, LocalTime time, String departure, String arrival) {
        Map<Long, Train> trains = new HashMap<>();
        final String query = "select * from route  \n" +
                "inner join train\n" +
                "on route.id=route_id" +
                " where departure_time>=? && departure_date =? && departure= ? && arrival =? && free_seats>0";
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setTime(1, Time.valueOf(time));
            st.setDate(2, Date.valueOf(date));
            st.setString(3, departure);
            st.setString(4, arrival);
            st.execute();
            TrainMapper trainMapper = new TrainMapper(new RouteMapper());

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Train train = trainMapper.extractFromResultSet(rs);
                trains.putIfAbsent(train.getId(), train);
            }
            return new ArrayList<>(trains.values());

        } catch (SQLException e) {
            e.printStackTrace();
//            throw new SQLException();
        }
        return null;
    }

    public void bookTheTicket(Train train) {
        train.setFreeSeats(train.getFreeSeats()-1);
        final String query = "UPDATE train SET free_seats = ? WHERE id = ?";
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setInt(1, train.getFreeSeats());
            st.setLong(2, train.getId());
            st.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Train entity) throws SQLException {

    }

    @Override
    public Optional<Train> findById(Long id) {
        final String query = "select * from train inner join route on route.id=route_id where train.id =?";
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setLong(1, id);
            st.execute();
            TrainMapper trainMapper = new TrainMapper(new RouteMapper());

            ResultSet rs = st.executeQuery();
            Train train=null;
            if (rs.next()) {
                train = trainMapper.extractFromResultSet(rs);
            }
            return Optional.ofNullable(train);

        } catch (SQLException e) {
            e.printStackTrace();
//            throw new SQLException();
        }
        return null;
    }

    @Override
    public List<Train> findAll() {
        return null;
    }

    @Override
    public void update(Train entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }
}
