package com.csci3130.trellobackend.user.controller;

import com.csci3130.trellobackend.task.model.TaskModel;
import com.csci3130.trellobackend.user.entity.UserModel;
import com.csci3130.trellobackend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    // post mapping creates a new object
    // put mapping updates a new object
    // delete mapping deletes an existing object

    @PostMapping("/save")
    public UserModel signUpUser(@RequestBody UserModel userModel){
        return userService.signUpUser(userModel);
    }

    @PutMapping("/assignTask/{userId}")
    public UserModel updateTask(@PathVariable Long userId, @RequestParam Long taskId){
        return userService.updateTask(userId, taskId);
    }

    @GetMapping("/getAll")
    public List<UserModel> getAllUsers(){
        return userService.getAllUsers();
    }

}
