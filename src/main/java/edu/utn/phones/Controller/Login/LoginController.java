package edu.utn.phones.Controller.Login;


import edu.utn.phones.Controller.Model.UserController;
import edu.utn.phones.Dto.LoginRequestDto;
import edu.utn.phones.Exceptions.GeneralExceptions.LoginException;
import edu.utn.phones.Domain.User;
import edu.utn.phones.Session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class LoginController {

    UserController userController;
    SessionManager sessionManager;

    @Autowired
    public LoginController(UserController userController, SessionManager sessionManager) {
        this.userController = userController;
        this.sessionManager = sessionManager;
    }


    @PostMapping("login/")
    public ResponseEntity login(@RequestBody LoginRequestDto loginRequestDto) throws LoginException {

        ResponseEntity response;

        if ("antenna".equals(loginRequestDto.getUsername()) && "12345".equals(loginRequestDto.getPassword())){
            response =  ResponseEntity.ok().headers(createHeaders("antenna1234")).build();
        }else {
            User u = userController.login(loginRequestDto.getUsername(), loginRequestDto.getPassword());
            String token = sessionManager.createSession(u);
            response = ResponseEntity.ok().headers(createHeaders(token)).build();
        }




        return response;
    }


    @PostMapping("logout/")
    public ResponseEntity logout(@RequestHeader("Authorization") String token) {
        sessionManager.removeSession(token);
        return ResponseEntity.ok().build();
    }

    private HttpHeaders createHeaders(String token) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Authorization", token);
        return responseHeaders;
    }


}
