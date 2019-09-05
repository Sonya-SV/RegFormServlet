package com.training.regform.model.dao.impl;

import com.training.regform.model.dao.TrainDao;
import com.training.regform.model.entity.Train;
import com.training.regform.model.mapper.TrainMapper;
import com.training.regform.model.mapper.UserMapper;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class JDBCTrainDao implements TrainDao {
    private Connection connection;

    public JDBCTrainDao (Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Train> findByRouteAndDateAndTime(LocalDate date, LocalTime time) {
        Map<Long, Train> trains = new HashMap<>();
        final String query = "select * from train where departure_time>=? && departure_date =?";
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setTime (1, Time.valueOf(time));
            st.setDate (2, Date.valueOf(date));
            st.execute();
            System.out.println(query);
            System.out.println(Time.valueOf(time));
            System.out.println(Date.valueOf(date));
            TrainMapper trainMapper = new TrainMapper();

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Train train = trainMapper.extractFromResultSet(rs);
//                train=trainMapper.makeUnique(trains, train);
                trains.putIfAbsent(train.getId(), train);
            }
            System.out.println("trains"+ trains.values().toString());
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
