package com.training.regform.model.dao.impl;

import com.training.regform.model.dao.TrainDao;
import com.training.regform.model.entity.Route;
import com.training.regform.model.entity.Train;
import com.training.regform.model.mapper.RouteMapper;
import com.training.regform.model.mapper.TrainMapper;
import com.training.regform.model.mapper.UserMapper;

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
                "on route.id=id_route" +
                " where departure_time>=? && departure_date =? && departure= ? && arrival =?";
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

    @Override
    public void create(Train entity) throws SQLException {

    }

    @Override
    public Train findById(int id) {
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
