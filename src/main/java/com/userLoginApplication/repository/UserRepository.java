package com.userLoginApplication.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userLoginApplication.model.User;
import com.userLoginApplication.model.UserStatus;
import java.util.List;

public interface UserRepository {
    void createUser(User user);
    void updateUserById(Long userId, User user);
    void deleteUserById(Long id);
    User getUserById(Long id) throws JsonProcessingException;

    List<User> getUsersByFirstName(String firstName);

    List<User> getAllUsersByStatus(UserStatus userStatus);

    List<Long> getUserIdByFirstName(String firstName);
    List<User> getAllUsers();


}
