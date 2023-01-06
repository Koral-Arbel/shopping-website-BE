package com.userLoginApplication.service;

public interface UserService {
    void createUser(CustomUserRequest customUser) throws Exception;
    CustomUser findUserByUsername(String username);
}
