package com.userLoginApplication.repository;

import com.userLoginApplication.model.CustomUser;

public interface UserRepository {
    void createUser(CustomUser customUser);
    void updateUserDetailsByAuth(CustomUser customUser,String username);
    void deleteUserById(String username);
    CustomUser findUserByUsername(String username);
}



