package com.userLoginApplication.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.userLoginApplication.model.UserRequest;
import com.userLoginApplication.model.UserStatus;
import com.userLoginApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void createUser(UserRequest userRequest) throws Exception {
        if(userRequest.getUserStatus() == UserStatus.INTERNAL){
            List<UserRequest> internalUser = userRepository.getAllUsersByStatus(UserStatus.INTERNAL);
            if(internalUser.size() < 10 ) {
                userRepository.createUser(userRequest);
            } else {
                throw new Exception("Cant create new user with internal status. Out of limit");
            }
        } else {
            userRepository.createUser(userRequest);
        }
    }

    @Override
    public void updateUserById(Long userId, UserRequest userRequest) throws Exception {
        if(userRequest.getUserStatus() == UserStatus.INTERNAL){
            UserRequest existingUser =userRepository.getUserById(userId);
            if(existingUser.getUserStatus() != UserStatus.INTERNAL) {
                List<UserRequest> internalUsers = userRepository.getAllUsersByStatus(UserStatus.INTERNAL);
                if(internalUsers.size() < 10){
                    userRepository.updateUserById(userId, userRequest);
                } else {
                    throw new Exception("Can't update user status to INTERNAL, Out of limit");
                }
            } else {
                userRepository.updateUserById(userId, userRequest);
            }
        } else {
            userRepository.updateUserById(userId, userRequest);
        }
    }

    @Override
    public void deleteUserById(Long userId) throws Exception {
        UserRequest existingUser = userRepository.getUserById(userId);
        if (existingUser != null) {
            userRepository.deleteUserById(userId);
        } else {
            throw new Exception("The user id: " + userId + "is not existing, so we can't delete it");
        }
    }

    @Override
    public UserRequest getUserById(Long userId) throws JsonProcessingException {
        return userRepository.getUserById(userId);
    }

    @Override
    public List<UserRequest> getUserByFirstName(String firstName) {
        return userRepository.getUsersByFirstName(firstName);
    }

    @Override
    public List<UserRequest> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public List<Long> getUserIdByFirstName(String firstName) {
        return userRepository.getUserIdByFirstName(firstName);
    }
}
