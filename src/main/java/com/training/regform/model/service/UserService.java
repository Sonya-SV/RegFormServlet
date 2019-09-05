package com.training.regform.model.service;

import com.training.regform.model.dao.DaoFactory;
import com.training.regform.model.dao.UserDao;
import com.training.regform.model.entity.User;

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
    public Optional<User> login(String username, String password){
        Optional<User> user;
        try(UserDao dao = daoFactory.createUserDao()){
            user = dao.findByUsernameAndPassword(username, password);
        }
        return user;
    }

}
