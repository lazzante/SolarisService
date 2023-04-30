package gunam.solaris.controllers;

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

    @PostMapping("/add")
    ResponseEntity<?> addAuthority(@RequestBody Authority authority){
       return authorityService.addAuthority(authority);
    }




}
