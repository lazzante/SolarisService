package gunam.solaris.services;

import gunam.solaris.entities.User;
import org.springframework.http.ResponseEntity;

public interface SignUpService {
    ResponseEntity<?> createUser(User user);

}
