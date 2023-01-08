package com.userLoginApplication.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.userLoginApplication.model.User;
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
    public Long createUser(User user) throws Exception {
        if (user.getUserStatus() == UserStatus.INTERNAL) {
            List<User> internalUser = userRepository.getAllUsersByStatus(UserStatus.INTERNAL);
            if (internalUser.size() < 10) {
                return userRepository.createUser(user);
            } else {
                throw new Exception("Cant create new user with internal status. Out of limit");
            }
        } else {
            return userRepository.createUser(user);
        }
    }


    @Override
    public void updateUserById(Long userId, User user) throws Exception {
        if(user.getUserStatus() == UserStatus.INTERNAL){
            User existingUser =userRepository.getUserById(userId);
            if(existingUser.getUserStatus() != UserStatus.INTERNAL) {
                List<User> internalUsers = userRepository.getAllUsersByStatus(UserStatus.INTERNAL);
                if(internalUsers.size() < 10){
                    userRepository.updateUserById(userId, user);
                } else {
                    throw new Exception("Can't update user status to INTERNAL, Out of limit");
                }
            } else {
                userRepository.updateUserById(userId, user);
            }
        } else {
            userRepository.updateUserById(userId, user);
        }
    }

    @Override
    public void deleteUserById(Long id) throws Exception {
        User existingUser = userRepository.getUserById(id);
        if (existingUser != null) {
            userRepository.deleteUserById(id);
        } else {
            throw new Exception("The user id: " + id + "is not existing, so we can't delete it");
        }
    }

    @Override
    public User getUserById(Long id) throws JsonProcessingException {
        return userRepository.getUserById(id);
    }

    @Override
    public List<User> getUserByFirstName(String firstName) {
        return userRepository.getUsersByFirstName(firstName);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public List<Long> getUserIdByFirstName(String firstName) {
        return userRepository.getUserIdByFirstName(firstName);
    }
}
