package com.userLoginApplication.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userLoginApplication.model.UserRequest;

import java.util.List;

public interface UserService{
    void createUser(UserRequest userRequest) throws Exception;
    void updateUserById(Long userId, UserRequest userRequest) throws Exception;
    void deleteUserById(Long userId) throws Exception;
    UserRequest getUserById(Long userId) throws JsonProcessingException;
    List<UserRequest> getUserByFirstName(String firstName);
    List<UserRequest> getAllUsers();
    List<Long> getUserIdByFirstName(String firstName);
}
