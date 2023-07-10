package gunam.solaris.controllers;

import gunam.solaris.entities.Division;
import gunam.solaris.entities.Log;
import gunam.solaris.services.LogService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/log")
public class LogController {

    private final LogService logService;

    @CrossOrigin
    @PostMapping("/add")
    ResponseEntity<?> addLog(@RequestBody Log log) {
        return logService.addLog(log);
    }

    @CrossOrigin
    @GetMapping("/getAll")
    ResponseEntity<?> findAllLogs() {
        return logService.findAllLogs();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findLogById(@PathVariable("id") int id) {
        return logService.findLogById(id);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteLog(@PathVariable("id") int id) {
        return logService.deleteLog(id);
    }


}
