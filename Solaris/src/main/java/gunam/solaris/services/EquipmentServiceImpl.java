package gunam.solaris.services;

import gunam.solaris.contracts.errors.RepositoryError;
import gunam.solaris.entities.Equipment;
import gunam.solaris.entities.Log;
import gunam.solaris.repositories.EquipmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository equipmentRepository;

    @Override
    public ResponseEntity<?> addEquipment(Equipment equipment) {
        equipmentRepository.save(equipment);
        return ResponseEntity.status(HttpStatus.OK).body("Equipment Saved DB Successfully");
    }

    @Override
    public ResponseEntity<?> findAllEquipments() {
        List<Equipment> equipments = equipmentRepository.findAll();
        if(equipments==null||equipments.isEmpty()){
            RepositoryError error = new RepositoryError(404,"Any equipment found !");
            return ResponseEntity.status(HttpStatus.OK).body(error);
        }
        return ResponseEntity.status(HttpStatus.OK).body(equipments);
    }

    @Override
    public ResponseEntity<?> findEquipmentById(int id) {

        Optional<Equipment> foundEquipment = equipmentRepository.findById(id);
        if(!foundEquipment.isPresent()){
            RepositoryError error = new RepositoryError(404,"No Equipment found !");
            return ResponseEntity.status(HttpStatus.OK).body(error);
        }

        Equipment equipment = foundEquipment.get();

        return ResponseEntity.status(HttpStatus.OK).body(equipment);
    }

    @Override
    public ResponseEntity<?> deleteEquipment(int id) {
        if (equipmentRepository.existsById(id)) {
            equipmentRepository.deleteById(id);
            return new ResponseEntity<>("Equipment Deleted Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Equipment Can Not Found By Given Id", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
