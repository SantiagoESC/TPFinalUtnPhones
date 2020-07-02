package edu.utn.phones.Controller.Model;


import edu.utn.phones.Domain.User;
import edu.utn.phones.Exceptions.GeneralExceptions.LoginException;
import edu.utn.phones.Service.UserService;
import edu.utn.phones.Utils.TestUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.when;


public class UserControllerTest {
    UserController userController;
    UserService userService;


    @Before
    public void setUp(){
        this.userService = mock(UserService.class);
        this.userController = new UserController(userService);
    }

    @Test
    public void testConstructor(){
        UserController u = new UserController(this.userService);
    }

    @Test
    public void loginOk() throws LoginException {
        User u = TestUtils.createUser();
        String username = "abulzomi";
        String password = "1234";
        when(this.userService.login(username,password)).thenReturn(u);
        User actual = this.userController.login(username,password);

        assertEquals(u,actual);
        verify(this.userService,times(1)).login(username,password);

    }

    @Test(expected = LoginException.class)
    public void loginLogiException() throws LoginException {


        when(this.userService.login(any(),any())).thenThrow(new LoginException());
        User actual = this.userController.login(null,null);



    }



}
