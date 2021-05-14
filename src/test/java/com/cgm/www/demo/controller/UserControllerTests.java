package com.cgm.www.demo.controller;

import com.cgm.www.demo.dao.UserDao;
import com.cgm.www.demo.dto.CreateUserRequest;
import com.cgm.www.demo.entity.User;
import com.cgm.www.demo.service.UserService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

//@RunWith(SpringRunner.class)
@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest(classes = DemoApplication.class)
public class UserControllerTests {
    @Mock
    private UserDao userDao;
    @InjectMocks
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
        ReflectionTestUtils.setField(userController, "userService", userService);
        Mockito.when(userDao.createUser(user)).thenReturn(1);
        //
        String result = userController.createUser(request);
        Assert.assertThat(result, org.hamcrest.Matchers.equalTo(id));
    }

    @Ignore
    @Test
    public void testCreateUser() {
        //UserController userController = new UserController();
        //UserController userController = Mockito.mock(UserController.class);
        //CreateUserRequest request = Mockito.mock(CreateUserRequest.class);
        //Mockito.when(request.getName()).thenReturn("xiaoming");
        //Mockito.when(request.getPwd()).thenReturn("1234");
        CreateUserRequest request = new CreateUserRequest("xiaoming", "1234");
        MockitoAnnotations.initMocks(this);
        UserService userService = Mockito.mock(UserService.class);
        Mockito.when(userService.createUser(request)).thenReturn("1");
        System.out.println("(1)=" + userService.createUser(request));
        String result = userController.createUser(request);
        Assert.assertThat(result, org.hamcrest.Matchers.equalTo("1"));
    }


}
