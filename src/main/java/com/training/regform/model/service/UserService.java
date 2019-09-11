package com.training.regform.model.service;

import com.training.regform.model.dao.DaoFactory;
import com.training.regform.model.dao.UserDao;
import com.training.regform.model.entity.User;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<User> getAllUsers(){
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.findAll();
        }
    }
    public void saveUser(User user) throws SQLException {
        UserDao dao = daoFactory.createUserDao();
        dao.create(user);
    }
    public void update(String firstName, String lastName, String password, User user) throws SQLException {
        UserDao dao = daoFactory.createUserDao();
        Optional<User> userToUpdate = dao.findById(user.getId());
        if(!userToUpdate.isEmpty()){
            User userr = userToUpdate.get();
            userr.setFirstName(firstName);
            userr.setLastName(lastName);
            userr.setPassword(password);
            dao.update(userr);
        }
    }
    public Optional<User> login(String username, String password){
        Optional<User> user;
        try(UserDao dao = daoFactory.createUserDao()){
            user = dao.findByUsernameAndPassword(username, password);
        }
        return user;
    }
    public void updateAccount(User user, BigDecimal replenishmentAmount) {
        try(UserDao dao = daoFactory.createUserDao()){
            dao.updateBalance(user, replenishmentAmount);
        }
    }

}
