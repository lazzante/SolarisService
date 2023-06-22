package gunam.solaris.controllers;

import gunam.solaris.entities.Position;
import gunam.solaris.services.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/position")
@AllArgsConstructor
public class PositionController {

    private final PositionService positionService;

    @CrossOrigin
    @PostMapping("/add")
    ResponseEntity<?> addPosition(@RequestBody Position position) {
        return positionService.addPosition(position);
    }

    @CrossOrigin
    @GetMapping("/getAll")
    ResponseEntity<?> getAllPositions() {
        return positionService.getAllPositions();
    }

    @GetMapping("/find/{id}")
    ResponseEntity<?> findPositionById(@PathVariable("id") int id) {
        return positionService.findPositionById(id);
    }


    @PutMapping("/update/{id}")
    ResponseEntity<?> updatePosition(@PathVariable("id") int id,@RequestBody Position position) {
        return positionService.updatePosition(id,position);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deletePosition(@PathVariable("id") int id) {
        return positionService.deletePosition(id);
    }

}
