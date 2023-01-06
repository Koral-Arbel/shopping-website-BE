package com.userLoginApplication.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userLoginApplication.model.UserRequest;
import com.userLoginApplication.model.UserStatus;

import java.util.List;

public interface UserRepository {
    void createUser(UserRequest userRequest);
    void updateUserById(Long userId, UserRequest userRequest);
    void deleteUserById(Long id);
    UserRequest getUserById(Long id) throws JsonProcessingException;

    List<UserRequest> getUsersByFirstName(String firstName);

    List<UserRequest> getAllUsersByStatus(UserStatus internal);

    List<Long> getUserIdByFirstName(String firstName);
    List<UserRequest> getAllUsers();


}
