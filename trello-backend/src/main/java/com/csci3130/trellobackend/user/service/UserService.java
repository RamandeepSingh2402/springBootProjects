package com.csci3130.trellobackend.user.service;

import com.csci3130.trellobackend.task.model.TaskModel;
import com.csci3130.trellobackend.task.service.TaskService;
import com.csci3130.trellobackend.user.entity.UserModel;
import com.csci3130.trellobackend.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserModel signUpUser(UserModel userModel){
        return userRepository.save(userModel);
    }

    @Autowired
    TaskService taskService;


    public List<UserModel> getAllUsers(){
        return userRepository.findAll();
    }

    public UserModel updateTask(Long userId, Long taskId){
        UserModel updatedUser = null;
        Optional<UserModel> user = null;
        try{
            user =  userRepository.findById(userId);
            if(user.isPresent()){
                UserModel userModel = user.get();
                TaskModel taskModel = taskService.findTaskById(taskId);

                List<TaskModel> tasks = userModel.getTasks();
                if(tasks!=null){
                    tasks = new ArrayList<>();
                }
                tasks.add(taskModel);
                userModel.setTasks(tasks);

                updatedUser = userRepository.save(userModel);

            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return  updatedUser;
    }
}