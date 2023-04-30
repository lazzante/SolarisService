package gunam.solaris.services;

import gunam.solaris.entities.Authority;
import gunam.solaris.entities.User;
import gunam.solaris.repositories.AuthorityRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {
    private final AuthorityRepository authorityRepository;
    @Override
    public ResponseEntity<?> addAuthority(Authority authority) {
        authorityRepository.save(authority);
        return ResponseEntity.status(HttpStatus.OK).body("Authority Successfully Saved In DB");
    }



}
