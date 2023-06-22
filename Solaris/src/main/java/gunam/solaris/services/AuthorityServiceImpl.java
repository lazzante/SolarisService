package gunam.solaris.services;

import gunam.solaris.entities.Authority;
import gunam.solaris.entities.User;
import gunam.solaris.repositories.AuthorityRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.*;

@Service
@AllArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {
    private final AuthorityRepository authorityRepository;

    @Override
    public ResponseEntity<?> addAuthority(Authority authority) {
        authorityRepository.save(authority);
        return ResponseEntity.status(HttpStatus.OK).body("Authority Successfully Saved In DB");
    }


    @Override
    public ResponseEntity<?> getAll() {
        List<Authority> authorities = authorityRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(authorities);

    }

    @Override
    public ResponseEntity<?> deleteAuthority(int id) {
        if (authorityRepository.existsById(id)) {
            authorityRepository.deleteById(id);
            return new ResponseEntity<>("Authority Deleted Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Authority Can Not Found By Given Id", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }


}
