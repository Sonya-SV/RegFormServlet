package com.training.regform.model.dao.impl;

import com.training.regform.model.dao.UserDao;
import com.training.regform.model.entity.User;
import com.training.regform.model.mapper.UserMapper;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

public class JDBCUserDao implements UserDao {
    private Connection connection;


    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User entity) throws SQLException {
        final String query = "insert into user(username, first_name, last_name, password, role, balance) values (?,?,?,?,?,?)";
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setString (1, entity.getUsername());
            st.setString   (2, entity.getFirstName());
            st.setString(3, entity.getLastName());
            st.setString(4, entity.getPassword());
            st.setString(5, entity.getRole().name());
            st.setBigDecimal(6, BigDecimal.ZERO);
            st.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        return null;
    }

    @Override
    public Optional<User> findByUsernameAndPassword(String username, String password) {
        final String query = "select * from user where username=? && password =?";
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setString (1, username);
            st.setString (2, password);
            UserMapper userMapper = new UserMapper();

            ResultSet rs = st.executeQuery();
            Optional<User> user=Optional.empty();
            if(rs.next())
                user=Optional.of(userMapper.extractFromResultSet(rs));
            return user;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        Map<Long, User> users = new HashMap<>();
        final String query = " select * from user";
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);

            UserMapper userMapper = new UserMapper();

            while (rs.next()) {
                User user = userMapper.extractFromResultSet(rs);
                users.putIfAbsent(user.getId(), user);
            }
               return new ArrayList<>(users.values());

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void update(User entity) {
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
