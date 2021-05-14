package com.cgm.www.demo.dao;

import com.cgm.www.demo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public int createUser(User user) {
        throw new RuntimeException();
    }
}
