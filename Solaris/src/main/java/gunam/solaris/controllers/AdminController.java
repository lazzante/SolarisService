package gunam.solaris.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/admin-panel")
    String testAuth(){
        return "Test successfully passed";
    }
}
