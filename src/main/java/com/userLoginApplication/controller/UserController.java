package com.userLoginApplication.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.userLoginApplication.model.User;
import com.userLoginApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping(value = "/user/createUser")
    public void createUser (@RequestBody User user) throws Exception {
        userService.createUser(user);
    }

    @PutMapping(value = "/user/{userId}/update")
    public void updateUserById(@PathVariable Long userId,
                               @RequestBody User user) throws Exception {
        userService.updateUserById(userId, user);
    }

    @DeleteMapping(value = "/user/{userId}/delete")
    public void deleteUserById (@PathVariable Long userId) throws Exception {
        userService.deleteUserById(userId);
    }

    @GetMapping(value = "/user/{userId}")
    public User getUserById (@PathVariable Long userId) throws JsonProcessingException {
        return userService.getUserById(userId);
    }
}
