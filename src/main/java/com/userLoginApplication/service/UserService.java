package com.userLoginApplication.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userLoginApplication.model.User;

import java.util.List;

public interface UserService{
    Long createUser(User user) throws Exception;
    void updateUserById(Long userId, User user) throws Exception;
    void deleteUserById(Long id) throws Exception;
    User getUserById(Long id) throws JsonProcessingException;
    List<User> getUserByFirstName(String firstName);
    List<User> getAllUsers();
    List<Long> getUserIdByFirstName(String firstName);
}
