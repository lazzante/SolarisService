package gunam.solaris.services;

import gunam.solaris.entities.Authority;
import gunam.solaris.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthorityService {
     ResponseEntity<?> addAuthority( Authority authority);



}
