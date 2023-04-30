package gunam.solaris.services;

import gunam.solaris.contracts.errors.ApiError;
import gunam.solaris.entities.User;
import gunam.solaris.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Service
public class SignUpServiceImpl implements SignUpService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Override
    public ResponseEntity<?> createUser(User user) {

        String username = user.getUsername();
        String password = user.getPassword();
        String firstname= user.getFirstname();
        String lastname = user.getLastname();

        ApiError error = new ApiError();
        Map<String,String> validationErrors = new HashMap<>();

        if(username==null||username.isEmpty()){
            validationErrors.put("usernameError","Username Can't Be Null !");

            error.setValidationErrors(validationErrors);
            error.setStatus(400);
            error.setMessage("Username Can't Be Null !");
            error.setPath("/signUp");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }

        if(password==null||password.isEmpty()){
            validationErrors.put("passwordError","Password Can't Be Null !");

            error.setValidationErrors(validationErrors);
            error.setStatus(400);
            error.setMessage("Password Can't Be Null !");
            error.setPath("/signUp");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }

        if(firstname==null||firstname.isEmpty()){
            validationErrors.put("firstNameError","First Name Can't Be Null !");

            error.setValidationErrors(validationErrors);
            error.setStatus(400);
            error.setMessage("First Name Can't Be Null !");
            error.setPath("/signUp");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }

        if(lastname==null||lastname.isEmpty()){
            validationErrors.put("lastNameError","Last Name Can't Be Null !");

            error.setValidationErrors(validationErrors);
            error.setStatus(400);
            error.setMessage("Last Name Can't Be Null !");
            error.setPath("/signUp");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }



        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
