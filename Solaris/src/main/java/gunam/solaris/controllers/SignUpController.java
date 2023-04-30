package gunam.solaris.controllers;

import gunam.solaris.entities.User;
import gunam.solaris.services.SignUpService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SignUpController {

    private final SignUpService signUpService;

    @CrossOrigin
    @PostMapping("/signUp")
    public ResponseEntity<?> createUser(@RequestBody User user){
        return signUpService.createUser(user);
    }


}
