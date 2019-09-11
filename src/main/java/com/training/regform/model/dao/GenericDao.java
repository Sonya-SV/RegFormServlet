package com.training.regform.model.dao;

import javax.swing.text.html.Option;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface GenericDao<T> extends AutoCloseable {
    void create(T entity) throws SQLException;
    Optional<T> findById(Long id);
    List<T> findAll();
//    List<T> findByUsername();
    void update(T entity) throws SQLException;
    void delete(int id);
    void close();
}
