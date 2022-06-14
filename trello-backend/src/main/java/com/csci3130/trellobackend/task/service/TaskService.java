package com.csci3130.trellobackend.task.service;

import com.csci3130.trellobackend.task.model.TaskModel;
import com.csci3130.trellobackend.task.repository.TaskRepository;
import com.csci3130.trellobackend.user.entity.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public TaskModel createTask(TaskModel taskModel){
        return taskRepository.save(taskModel);
    }

    public TaskModel findTaskById(Long taskId){

        TaskModel taskModel = null;

        Optional<TaskModel> optionalTaskModel = taskRepository.findById(taskId);
        if(optionalTaskModel.isPresent())
        {
            taskModel = optionalTaskModel.get();
        }

        return taskModel;

    }

    public void deleteTask(Long taskId){
        taskRepository.deleteById(taskId);
    }

}
