package gunam.solaris.controllers;

import gunam.solaris.entities.Title;
import gunam.solaris.services.TitleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/title")
@AllArgsConstructor
public class TitleController {
    private final TitleService titleService;


    @PostMapping("/add")
    ResponseEntity<?> addTitle(@RequestBody Title title){
        return titleService.addTitle(title);
    };

    @GetMapping("/findAll")
    ResponseEntity<?> findAllTitles(){
        return titleService.findAllTitles();
    };


    @GetMapping("/find/{id}")
    ResponseEntity<?> findTitleById(@PathVariable("id") int id){
        return titleService.findTitleById(id);
    };



}
