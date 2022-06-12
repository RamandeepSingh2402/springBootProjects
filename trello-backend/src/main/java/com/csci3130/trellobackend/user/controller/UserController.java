package com.csci3130.trellobackend.user.controller;

import com.csci3130.trellobackend.user.entity.UserModel;
import com.csci3130.trellobackend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public void signUpUser(@RequestBody UserModel userModel){
        userService.signUpUser(userModel);
    }
}
