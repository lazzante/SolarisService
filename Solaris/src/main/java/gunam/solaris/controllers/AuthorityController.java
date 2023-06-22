package gunam.solaris.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gunam.solaris.entities.Authority;
import gunam.solaris.services.AuthorityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authority")
@AllArgsConstructor
public class AuthorityController {
    private final AuthorityService authorityService;

    @CrossOrigin
    @PostMapping("/add")
    ResponseEntity<?> addAuthority(@RequestBody Authority authority){
       return authorityService.addAuthority(authority);
    }


    @CrossOrigin
    @GetMapping("/getAll")
    ResponseEntity<?> getAll() {
        return authorityService.getAll();
    }



    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteAuthority(@PathVariable("id") int id) {
        return authorityService.deleteAuthority(id);
    }


}
