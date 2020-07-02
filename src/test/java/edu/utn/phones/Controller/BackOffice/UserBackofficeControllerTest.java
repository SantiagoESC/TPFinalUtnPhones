package edu.utn.phones.Controller.BackOffice;

import edu.utn.phones.Configuration.Configuration;
import edu.utn.phones.Controller.Model.UserController;
import edu.utn.phones.Domain.User;
import edu.utn.phones.Exceptions.GeneralExceptions.NoContentToShowException;
import edu.utn.phones.Exceptions.GeneralExceptions.ResourceNotFoundException;
import edu.utn.phones.Utils.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Configuration.class)
public class UserBackofficeControllerTest {

    private UserBackofficeController userBackofficeController;
    private UserController userController;


    @Before
    public void setUp() {
        this.userController = mock(UserController.class);
        this.userBackofficeController = new UserBackofficeController(this.userController);
    }


    @Test
    public void testAddOK() {


        User preAdd = TestUtils.createUserNoId();
        User postAdd = TestUtils.createUser();
        PowerMockito.mockStatic(Configuration.class);
        when(this.userController.add(preAdd)).thenReturn(postAdd);
        when(Configuration.getLocation(postAdd)).thenReturn(URI.create("http://localhost:8080/api/user/1"));
        ResponseEntity response = this.userBackofficeController.add(preAdd);

    }

    @Test
    public void testContruct() {
        UserBackofficeController c = new UserBackofficeController(mock(UserController.class));
    }

    @Test
    public void testUpdateOk() throws ResourceNotFoundException {
        User c = TestUtils.createUser();
        User updated = TestUtils.createUser2();
        when(this.userController.getById(1)).thenReturn(c);
        when(this.userController.update(any())).thenReturn(updated);
        ResponseEntity responseEntity = this.userBackofficeController.update(c, 1);

        assertEquals(ResponseEntity.ok().build(), responseEntity);
        verify(this.userController, times(1)).update(c);

    }

    @Test(expected = ResourceNotFoundException.class)
    public void testUpdateResourceNotFoundException() throws ResourceNotFoundException {
        when(this.userController.getById(any())).thenThrow(new ResourceNotFoundException());
        ResponseEntity responseEntity = this.userBackofficeController.update(new User(), 1);
    }


    @Test
    public void testDeleteOk() throws ResourceNotFoundException {

        User c = TestUtils.createUser();
        when(this.userController.getById(1)).thenReturn(c);
        doNothing().when(this.userController).delete(c);
        ResponseEntity responseEntity = this.userBackofficeController.delete(1);

        assertEquals(ResponseEntity.ok().build(), responseEntity);

        verify(this.userController, times(1)).delete(c);

    }


    @Test(expected = ResourceNotFoundException.class)
    public void testDeleteResourceNotFoundExcetion() throws ResourceNotFoundException {
        when(this.userController.getById(any())).thenThrow(new ResourceNotFoundException());
        ResponseEntity responseEntity = this.userBackofficeController.delete(1);
    }

    @Test
    public void testGetByIdOK() throws ResourceNotFoundException {
        User c = TestUtils.createUser();
        when(this.userController.getById(1)).thenReturn(c);

        ResponseEntity<User> resourceEntity = this.userBackofficeController.getById(1);

        assertEquals(ResponseEntity.ok(c), resourceEntity);
        assertEquals(c, resourceEntity.getBody());
        verify(this.userController, times(1)).getById(1);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetByIdResourceNotFoundException() throws ResourceNotFoundException {
        when(this.userController.getById(any())).thenThrow(new ResourceNotFoundException());
        ResponseEntity responseEntity = this.userBackofficeController.getById(1);
    }


    @Test
    public void testGetAllOk() throws NoContentToShowException, ResourceNotFoundException {
        List<User> list = TestUtils.createUserList();
        when(this.userController.getAll()).thenReturn(list);

        ResponseEntity<List<User>> responseEntity = this.userBackofficeController.getAll();

        assertEquals(ResponseEntity.ok(list), responseEntity);
        verify(this.userController, times(1)).getAll();
    }

    @Test(expected = NoContentToShowException.class)
    public void testGetAllNoContentToShowException() throws NoContentToShowException, ResourceNotFoundException {
        when(this.userController.getAll()).thenThrow(new NoContentToShowException());
        ResponseEntity responseEntity = this.userBackofficeController.getAll();
    }
}
