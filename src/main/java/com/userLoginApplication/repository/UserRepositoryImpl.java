package com.userLoginApplication.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.userLoginApplication.model.UserRequest;
import com.userLoginApplication.model.UserStatus;
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


        @Autowired
        private ObjectMapper objectMapper;


        @Override
        public void createUser(UserRequest userRequest) {
            String sql = "INSERT INTO " + USER_REQUEST_TABLE_NAME + " (first_name, last_name, email, phone, country, city) VALUES (?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql,
                    userRequest.getFirstName(),
                    userRequest.getLastName(),
                    userRequest.getEmail(),
                    userRequest.getPhone(),
                    userRequest.getCountry(),
                    userRequest.getCity());
            System.out.println("successfully created");
        }


        @Override
        public void updateUserById(Long userId, UserRequest userRequest) {
            String sql = "UPDATE " + USER_REQUEST_TABLE_NAME + " SET first_name=?, last_name=?, email=?, phone=?, country=?, city=? " +
                    "WHERE user_id=?";
            jdbcTemplate.update(sql, userRequest.getFirstName(), userRequest.getLastName(), userRequest.getEmail(), userRequest.getPhone(), userRequest.getCountry(), userRequest.getCity(), userId);
        }

        @Override
        public void deleteUserById(Long userId) {
            String sql = "DELETE FROM " + USER_REQUEST_TABLE_NAME + " WHERE user_id=?";
            jdbcTemplate.update(sql, userId);
        }

        @Override
        public UserRequest getUserById(Long userId) {
            String sql = "SELECT * FROM " + USER_REQUEST_TABLE_NAME + " WHERE user_id=?";
            try {
                return jdbcTemplate.queryForObject(sql, new com.userLoginApplication.repository.UserMapper(), userId);
            } catch (EmptyResultDataAccessException error) {
                return null;
            }
        }

        @Override
        public List<UserRequest> getUsersByFirstName(String firstName) {
            String sql = "SELECT * FROM " + USER_REQUEST_TABLE_NAME + " WHERE first_name=?";
            try {
                return jdbcTemplate.query(sql, new com.userLoginApplication.repository.UserMapper(), firstName);
            } catch (EmptyResultDataAccessException error) {
                return null;
            }
        }


        @Override
        public List<UserRequest> getAllUsersByStatus(UserStatus internal) {
            String sql = "SELECT * FROM " + USER_REQUEST_TABLE_NAME + " AS C WHERE C.status = ?";
            try {
                return jdbcTemplate.query(sql, new com.userLoginApplication.repository.UserMapper());
            } catch (EmptyResultDataAccessException error) {
                return null;
            }
        }

        @Override
        public List<Long> getUserIdByFirstName(String firstName) {
            return null;
        }

        @Override
        public List<UserRequest> getAllUsers() {
            return null;
        }
    }


