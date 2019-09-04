package com.training.regform.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T> extends AutoCloseable {
    void create(T entity) throws SQLException;
    T findById(int id);
    List<T> findAll();
//    List<T> findByUsername();
    void update(T entity);
    void delete(int id);
    void close();
}
