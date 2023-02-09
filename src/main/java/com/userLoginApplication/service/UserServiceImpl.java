package com.userLoginApplication.service;

import com.userLoginApplication.model.CustomUser;
import com.userLoginApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    FavoriteListService favoriteListService;
    @Autowired
    UserOrderService userOrderService;
    @Autowired
    OrderListService orderListService;

    @Override
    public void createUser(CustomUser customUser) throws Exception {
        CustomUser existingCustomUser = userRepository.findUserByUsername(customUser.getUsername());
        if (existingCustomUser != null) {
            throw new Exception("Username " + customUser.getUsername() + " is already taken");
        }
        userRepository.createUser(customUser);
    }

    @Override
    public void updateUserDetailsByAuth(CustomUser customUser, String username) {
        userRepository.updateUserDetailsByAuth(customUser, username);
    }

    @Override
    public void deleteUserDetailsByAuth(String username) {
        userRepository.deleteUserById(username);
    }

    @Override
    public CustomUser findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}





