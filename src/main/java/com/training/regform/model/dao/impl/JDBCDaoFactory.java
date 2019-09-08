package com.training.regform.model.dao.impl;

import com.training.regform.model.dao.DaoFactory;
import com.training.regform.model.dao.TicketDao;
import com.training.regform.model.dao.TrainDao;
import com.training.regform.model.dao.UserDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    public UserDao createUserDao() {

        return new JDBCUserDao(getConnection());
    }

    @Override
    public TicketDao createTicketDao() {
        return new JDBCTicketDao(getConnection());
    }

    @Override
    public TrainDao createTrainDao() {
        return new JDBCTrainDao(getConnection());
    }

    private Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
