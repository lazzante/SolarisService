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


    @CrossOrigin
    @PostMapping("/add")
    ResponseEntity<?> addTitle(@RequestBody Title title){
        return titleService.addTitle(title);
    };

    @CrossOrigin
    @GetMapping("/getAll")
    ResponseEntity<?> findAllTitles(){
        return titleService.findAllTitles();
    };


    @CrossOrigin
    @GetMapping("/find/{id}")
    ResponseEntity<?> findTitleById(@PathVariable("id") int id){
        return titleService.findTitleById(id);
    };

    @CrossOrigin
    @DeleteMapping ("/delete/{id}")
    ResponseEntity<?> deleteTitle(@PathVariable("id") int id){
        return titleService.deleteTitle(id);
    };




}
