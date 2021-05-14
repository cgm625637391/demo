package com.cgm.www.demo.service;

import com.cgm.www.demo.dao.UserDao;
import com.cgm.www.demo.dto.CreateUserRequest;
import com.cgm.www.demo.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTests {
    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserService userService;

    @Test
    public void testCreateUser() {
        String name = "xiaoming";
        String pwd = "1234";
        String id = "01";
        User user = new User(id, name, pwd);
        CreateUserRequest request = new CreateUserRequest(name, pwd);
        //
        Mockito.when(userDao.createUser(user)).thenReturn(1);
        //
        String result = userService.createUser(request);
        Assert.assertThat(result, org.hamcrest.Matchers.equalTo("01"));
    }
}
