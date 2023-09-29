package gunam.solaris.services;

import gunam.solaris.entities.EquipmentUser;
import org.springframework.http.ResponseEntity;

public interface EquipmentUserService {
    ResponseEntity<?> findAllEquipmentUsers();
    ResponseEntity<?> findEquipmentUsersByEquipmentId(int equipmentId);
    ResponseEntity<?> addEquipmentUser(EquipmentUser equipmentUser);

    ResponseEntity<?> updateEquipmentUser(int id,EquipmentUser equipmentUser);


}
