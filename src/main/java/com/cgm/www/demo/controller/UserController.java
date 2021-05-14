package com.cgm.www.demo.controller;

import com.cgm.www.demo.dto.CreateUserRequest;
import com.cgm.www.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("create")
    public String createUser(CreateUserRequest request) {
        return userService.createUser(request);
    }
}
