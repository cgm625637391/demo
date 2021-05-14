package com.cgm.www.demo.service;

import com.cgm.www.demo.dao.UserDao;
import com.cgm.www.demo.dto.CreateUserRequest;
import com.cgm.www.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public String createUser(CreateUserRequest request) {
        String id = "01";
        User user = new User(id, request.getName(), request.getPwd());
        userDao.createUser(user);
        return id;
    }
}
