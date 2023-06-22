package gunam.solaris.controllers;

import gunam.solaris.entities.User;
import gunam.solaris.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @CrossOrigin
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllUsers() {
        return userService.getAllUsers();
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
        return userService.deleteUser(id);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable("id") int id) {
        return userService.findUserById(id);
    }



}
