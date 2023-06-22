package gunam.solaris.services;

import gunam.solaris.contracts.errors.ApiError;
import gunam.solaris.entities.Authority;
import gunam.solaris.entities.User;
import gunam.solaris.repositories.AuthorityRepository;
import gunam.solaris.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Service
public class SignUpServiceImpl implements SignUpService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<?> createUser(User user) {


        String uid = user.getUid();
        String email=user.getEmail();
        String username = user.getUsername();
        String password = user.getPassword();
        String firstname= user.getFirstname();
        String lastname = user.getLastname();
        Set<Authority> authorities = user.getAuthorities();


        ApiError error = new ApiError();
        Map<String,String> validationErrors = new HashMap<>();

        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
