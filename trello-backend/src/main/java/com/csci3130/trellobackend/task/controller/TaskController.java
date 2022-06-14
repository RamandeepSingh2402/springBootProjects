package com.csci3130.trellobackend.task.controller;

import com.csci3130.trellobackend.task.model.TaskModel;
import com.csci3130.trellobackend.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping("/save")
    public TaskModel createTask(@RequestBody TaskModel taskModel){
        return taskService.createTask(taskModel);
    }

    @DeleteMapping("/delete/{taskId}")
    public void deleteTask(@PathVariable Long taskId){
        taskService.deleteTask(taskId);
    }

}
