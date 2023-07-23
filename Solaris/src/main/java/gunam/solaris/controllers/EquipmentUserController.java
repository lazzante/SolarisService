package gunam.solaris.controllers;

import gunam.solaris.entities.EquipmentUser;
import gunam.solaris.entities.Labratory;
import gunam.solaris.services.EquipmentUserService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/equser")
public class EquipmentUserController {

    private final EquipmentUserService equipmentUserService;


    @CrossOrigin
    @GetMapping("/getAll")
    ResponseEntity<?> findAllEquipments() {
        return equipmentUserService.findAllEquipmentUsers();
    }


    @CrossOrigin
    @GetMapping("/getUsersByEqId/{equipmentId}")
    ResponseEntity<?> findEquipmentUsersByEquipmentId(@PathVariable("equipmentId") int equipmentId) {
        return equipmentUserService.findEquipmentUsersByEquipmentId(equipmentId);
    }

    @CrossOrigin
    @PostMapping("/add")
    ResponseEntity<?> addEquipmentUser(@RequestBody EquipmentUser equipmentUser) {
        return equipmentUserService.addEquipmentUser(equipmentUser);
    }





}
