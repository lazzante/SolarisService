package gunam.solaris.services;

import gunam.solaris.contracts.errors.RepositoryError;
import gunam.solaris.entities.EquipmentUser;
import gunam.solaris.entities.Position;
import gunam.solaris.repositories.EquipmentUserReposityory;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public ResponseEntity<?> updateEquipmentUser(int id, EquipmentUser equipmentUser) {
       /* EquipmentUser equipmentUser1 = equipmentUserRepository.findById(id).orElse(null);
        if(equipmentUser1!=null){
            equipmentUserRepository.deleteById(id);
            equipmentUserRepository.save(equipmentUser);
            return ResponseEntity.status(HttpStatus.OK).body("Success");
        }
        else{
            return ResponseEntity.status(HttpStatus.OK).body("BAŞARISIZ");

        }
        */



        Optional<EquipmentUser> foundEquipmentUser = equipmentUserRepository.findById(id);
        if (foundEquipmentUser.isPresent()) {
            EquipmentUser _equipmentUser = foundEquipmentUser.get();
            _equipmentUser.setStatus(equipmentUser.getStatus());

            equipmentUserRepository.save(_equipmentUser);
            return new ResponseEntity<>("Equipment User Updated Successfully", HttpStatus.OK);
        }

        else {
            return new ResponseEntity<>("Equipment User Can Not Found By Given Id", HttpStatus.NOT_FOUND);
        }




    }


}


