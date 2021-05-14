package com.cgm.www.demo.controller;

import com.cgm.www.demo.dto.CreateUserRequest;
import com.cgm.www.demo.entity.User;
import com.cgm.www.demo.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTests {
    @Mock
    private UserService userService;
    @InjectMocks
    private UserController userController;

    @Test
    public void testCreateUser2() {
        String name = "xiaoming";
        String pwd = "1234";
        String id = "01";
        User user = new User(id, name, pwd);
        CreateUserRequest request = new CreateUserRequest(name, pwd);
        //
        Mockito.when(userService.createUser(request)).thenReturn("01");
        //
        String result = userController.createUser(request);
        Assert.assertThat(result, org.hamcrest.Matchers.equalTo("01"));
    }
}
