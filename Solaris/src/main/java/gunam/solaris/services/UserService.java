package gunam.solaris.services;

import gunam.solaris.entities.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> getAllUsers();

    ResponseEntity<?> deleteUser(int id);

    ResponseEntity<?> findUserById(int id);

    ResponseEntity<?> findUserByUid(String uid);




    }
