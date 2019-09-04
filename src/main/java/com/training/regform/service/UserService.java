package com.training.regform.service;

import com.training.regform.dao.DaoFactory;
import com.training.regform.dao.UserDao;
import com.training.regform.entity.User;

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
