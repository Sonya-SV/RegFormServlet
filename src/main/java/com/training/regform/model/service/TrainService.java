package com.training.regform.model.service;

import com.training.regform.controller.exception.NoSeatsException;
import com.training.regform.model.dao.DaoFactory;
import com.training.regform.model.dao.TrainDao;
import com.training.regform.model.dao.UserDao;
import com.training.regform.model.entity.Route;
import com.training.regform.model.entity.Train;
import com.training.regform.model.entity.User;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public class TrainService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Train> getAllTrainsByRouteAndDateAndTime(LocalDate date, LocalTime time, String departure, String arrival){
        try (TrainDao dao = daoFactory.createTrainDao()) {
            return dao.findByRouteAndDateAndTime(date, time, departure, arrival);
        }
    }
    public Optional<Train> findById(Long id){
        try (TrainDao dao = daoFactory.createTrainDao()) {
            return dao.findById(id);
        }
    }
    public void bookTheSeat(Train train) throws NoSeatsException {
        try(TrainDao trainDao = daoFactory.createTrainDao()){
            trainDao.bookTheSeat(train);
        }
    }
//    public void buyTheTicket(Train train) {
//        try (TrainDao dao = daoFactory.createTrainDao()) {
//           dao.buyTheTicket(train);
//        }
//    }
//    public void saveUser(User user) throws SQLException {
//        UserDao dao = daoFactory.createUserDao();
//        dao.create(user);
//    }
//    public Optional<User> login(String username, String password){
//        Optional<User> user;
//        try(UserDao dao = daoFactory.createUserDao()){
//            user = dao.findByUsernameAndPassword(username, password);
//        }
//        return user;
//    }
}
