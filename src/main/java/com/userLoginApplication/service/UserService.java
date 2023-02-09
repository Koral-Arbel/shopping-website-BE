package com.userLoginApplication.service;

import com.userLoginApplication.model.CustomUser;

public interface UserService {
    void createUser(CustomUser customUser) throws Exception;

    void updateUserDetailsByAuth(CustomUser customUser, String username);

    void deleteUserDetailsByAuth(String username);

    CustomUser findUserByUsername(String username);
}
