package gunam.solaris.services;

import gunam.solaris.entities.Equipment;
import org.springframework.http.ResponseEntity;

public interface EquipmentService {
    ResponseEntity<?> addEquipment(Equipment equipment);

    ResponseEntity<?> findAllEquipments();

    ResponseEntity<?> findEquipmentById(int id);
    ResponseEntity<?> deleteEquipment(int id);
}
