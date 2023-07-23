package gunam.solaris.services;

import gunam.solaris.contracts.errors.RepositoryError;
import gunam.solaris.entities.EquipmentUser;
import gunam.solaris.repositories.EquipmentUserReposityory;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipmentUserServiceImpl implements EquipmentUserService {

    private EquipmentUserReposityory equipmentUserRepository;


    @Override
    public ResponseEntity<?> findAllEquipmentUsers() {
        List<EquipmentUser> equipmentUsers =  equipmentUserRepository.findAll();

        if(equipmentUsers==null||equipmentUsers.isEmpty()){
            RepositoryError error = new RepositoryError(404,"Any equipment users found !");
            return ResponseEntity.status(HttpStatus.OK).body(error);
        }
        System.out.println("LİSTE DOLDURULDU");
        return ResponseEntity.status(HttpStatus.OK).body(equipmentUsers);
    }

    @Override
    public ResponseEntity<?> findEquipmentUsersByEquipmentId(int equipmentId) {
        List<EquipmentUser> foundEquipmentUsers =  equipmentUserRepository.findByEquipmentId(equipmentId);
        if(foundEquipmentUsers==null||foundEquipmentUsers.isEmpty()){
            RepositoryError error = new RepositoryError(404,"Any equipment users found !");
            return ResponseEntity.status(HttpStatus.OK).body(error);
        }
        return ResponseEntity.status(HttpStatus.OK).body(foundEquipmentUsers);

    }

    @Override
    public ResponseEntity<?> addEquipmentUser(EquipmentUser equipmentUser) {
        equipmentUserRepository.save(equipmentUser);
        return ResponseEntity.status(HttpStatus.OK).body("Equipment User Saved In DB Successfully");
    }



}


