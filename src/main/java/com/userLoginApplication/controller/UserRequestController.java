package com.userLoginApplication.controller;


import com.userLoginApplication.model.UserRequest;
import com.userLoginApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRequestController {

    @Autowired
    private UserService userService;



    @PostMapping(value = "/user/createUser")
    public void createUser (@RequestBody UserRequest userRequest) throws Exception {
        userService.createUser(userRequest);
    }

    @PutMapping(value = "/user/{userId}/update")
    public void updateUserById(@PathVariable Long userId,
                               @RequestBody UserRequest userRequest) throws Exception {
        userService.updateUserById(userId, userRequest);
    }

    @DeleteMapping(value = "/user/{userId}/delete")
    public void deleteUserById (@PathVariable Long userId) throws Exception {
        userService.deleteUserById(userId);
    }

    @GetMapping(value = "/user/{userId}")
    public UserRequest getUserById (@PathVariable Long userId) throws Exception {
        return userService.getUserById(userId);
    }
}
