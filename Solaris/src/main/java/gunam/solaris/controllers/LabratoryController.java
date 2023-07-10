package gunam.solaris.controllers;

import gunam.solaris.entities.Labratory;
import gunam.solaris.services.LabratoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/labratory")
public class LabratoryController {

    private final LabratoryService labratoryService;

    @CrossOrigin
    @PostMapping("/add")
    ResponseEntity<?> addLabratory(@RequestBody Labratory labratory) {
        return labratoryService.addLabratory(labratory);
    }

    @CrossOrigin
    @GetMapping("/getAll")
    ResponseEntity<?> findAllLabratories() {
        return labratoryService.findAllLabratories();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findLabratoryById(@PathVariable("id") int id) {
        return labratoryService.findLabratoryById(id);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteLabratory(@PathVariable("id") int id) {
        return labratoryService.deleteLabratory(id);
    }
}
