package gunam.solaris.controllers;

import gunam.solaris.entities.Equipment;
import gunam.solaris.services.EquipmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/equipment")
public class EquipmentController {

    private final EquipmentService equipmentService;

    @CrossOrigin
    @PostMapping("/add")
    ResponseEntity<?> addEquipment(@RequestBody Equipment equipment) {
        return equipmentService.addEquipment(equipment);
    }

    @CrossOrigin
    @GetMapping("/getAll")
    ResponseEntity<?> findAllEquipments() {
        return equipmentService.findAllEquipments();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findEquipmentById(@PathVariable("id") int id) {
        return equipmentService.findEquipmentById(id);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteEquipment(@PathVariable("id") int id) {
        return equipmentService.deleteEquipment(id);
    }
}
