package gunam.solaris.controllers;

import gunam.solaris.services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @CrossOrigin
    @PostMapping("/login")
    ResponseEntity<Object> login(){
       return loginService.login();
    }

}
