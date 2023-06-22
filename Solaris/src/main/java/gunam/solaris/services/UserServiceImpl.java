package gunam.solaris.services;

import gunam.solaris.entities.Position;
import gunam.solaris.entities.User;
import gunam.solaris.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;



    @Override
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userRepository.findAll();
        if(users==null||users.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Any user found !");
        }
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }


    @Override
    public ResponseEntity<?> deleteUser(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return new ResponseEntity<>("User Deleted Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User Can Not Found By Given Id", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }


    @Override
    public ResponseEntity<?> findUserById(int id) {
        var user =userRepository.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
