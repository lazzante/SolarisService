package gunam.solaris.services;

import gunam.solaris.contracts.errors.RepositoryError;
import gunam.solaris.entities.Position;
import gunam.solaris.entities.Title;
import gunam.solaris.entities.User;
import gunam.solaris.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<User> foundUser = userRepository.findById(id);
        if(!foundUser.isPresent()){
            RepositoryError error = new RepositoryError(404,"No User found !");
            return ResponseEntity.status(HttpStatus.OK).body(error);
        }

        User user = foundUser.get();
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @Override
    public ResponseEntity<?> findUserByUid(String uid) {
        Optional<User> foundUser = Optional.ofNullable(userRepository.findUserByUid(uid));
        if(!foundUser.isPresent()){
            RepositoryError error = new RepositoryError(404,"No User found !");
            return ResponseEntity.status(HttpStatus.OK).body(error);
        }
        User user = foundUser.get();
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }


}
