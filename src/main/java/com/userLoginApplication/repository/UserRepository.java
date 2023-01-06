package com.userLoginApplication.repository;

public interface UserRepository {
    void createUser(CustomUser customUser);
    CustomUser findUserByUsername(String username);
}
