package com.csci3130.trellobackend.user.service;

import com.csci3130.trellobackend.user.entity.UserModel;
import com.csci3130.trellobackend.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserModel signUpUser(UserModel userModel){
        return userRepository.save(userModel);
    }
}
