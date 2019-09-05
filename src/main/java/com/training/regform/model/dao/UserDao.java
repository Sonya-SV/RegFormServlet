package com.training.regform.model.dao;

import com.training.regform.model.entity.User;

import java.util.Optional;

public interface UserDao extends GenericDao<User> {
    Optional<User> findByUsernameAndPassword(String username, String password);
}
