package edu.utn.phones.Service;

import edu.utn.phones.Domain.User;
import edu.utn.phones.Exceptions.GeneralExceptions.LoginException;
import edu.utn.phones.Repository.IUserRepository;
import edu.utn.phones.Utils.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

public class UserServiceTest {


    private IUserRepository userRepository;
    private UserService userService;


    @Before
    public void setUp(){
        this.userRepository=mock(IUserRepository.class);
        this.userService = new UserService(this.userRepository);
    }



    @Test
    public void loginOK() throws LoginException {
        User u = TestUtils.createUser();
        String username="abulzomi";
        String password="1234";
        when(userRepository.findByUsernameAndPassword(username,password)).thenReturn(Optional.of(u));
        User actual = this.userService.login(username,password);

        assertEquals(u,actual);
    }


    @Test(expected = LoginException.class)
    public void loginLoginException() throws LoginException {

        when(userRepository.findByUsernameAndPassword(any(),any())).thenReturn(java.util.Optional.ofNullable(null));
        User actual = this.userService.login("Hola","Hola");

//        Mockito.verify(this.userRepository,Mockito.times(1)).findByUsernameAndPassword(any(),any());
    }
}
