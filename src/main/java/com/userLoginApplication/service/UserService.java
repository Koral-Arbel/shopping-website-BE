package com.userLoginApplication.service;

import com.userLoginApplication.model.UserRequest;

import java.util.List;

public interface UserService{
    void createUser(UserRequest userRequest) throws Exception;
    void updateUser(Long userId, UserRequest userRequest) throws Exception;
    void deleteUserById(Long userId) throws Exception;
    Long getUserById(Long userId) throws Exception;
    List<UserRequest> getUserByFirstName(String firstName);
    List<UserRequest> getAllUsers();
    List<Long> getUserIdByFirstName(String firstName);
}
