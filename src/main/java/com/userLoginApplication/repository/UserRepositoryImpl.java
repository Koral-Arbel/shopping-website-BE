package com.userLoginApplication.repository;

import com.userLoginApplication.model.User;
import com.userLoginApplication.model.UserStatus;
import com.userLoginApplication.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


    @Repository
    public class UserRepositoryImpl implements UserRepository{
        private static final String USER_REQUEST_TABLE_NAME = "user_request";
        @Autowired
        private JdbcTemplate jdbcTemplate;


        @Override
        public Long createUser(User user) {
            String sql = "INSERT INTO " + USER_REQUEST_TABLE_NAME + " (first_name, last_name, email, phone, country, city, user_status) VALUES (?, ?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone(), user.getCountry(), user.getCity(), user.getUserStatus().name());
            return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
        }


        @Override
        public void updateUserById(Long userId, User user) {
            String sql = "UPDATE " + USER_REQUEST_TABLE_NAME + " SET first_name=?, last_name=?, email=?, phone=?, country=?, city=?, user_status=? " +
                    "WHERE user_id=?";
            jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone(), user.getCountry(), user.getCity(), user.getUserStatus().name(), userId);
        }

        @Override
        public void deleteUserById(Long id) {
            String sql = "DELETE FROM " + USER_REQUEST_TABLE_NAME + " WHERE user_id=?";
            jdbcTemplate.update(sql, id);
        }

        @Override
        public User getUserById(Long id) {
            String sql = "SELECT * FROM " + USER_REQUEST_TABLE_NAME + " WHERE user_id=?";
            try {
                return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
            } catch (EmptyResultDataAccessException error) {
                return null;
            }
        }

        @Override
        public List<User> getUsersByFirstName(String firstName) {
            String sql = "SELECT * FROM " + USER_REQUEST_TABLE_NAME + " WHERE first_name=?";
            try {
                return jdbcTemplate.query(sql, new UserMapper(), firstName);
            } catch (EmptyResultDataAccessException error) {
                return null;
            }
        }


        @Override
        public List<User> getAllUsersByStatus(UserStatus userStatus) {
            String sql = "SELECT * FROM " + USER_REQUEST_TABLE_NAME + " AS C WHERE C.status = ?";
            try {
                return jdbcTemplate.query(sql, new UserMapper());
            } catch (EmptyResultDataAccessException error) {
                return null;
            }
        }

        @Override
        public List<Long> getUserIdByFirstName(String firstName) {
            return null;
        }

        @Override
        public List<User> getAllUsers() {
            return null;
        }
    }


