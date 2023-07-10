package gunam.solaris.services;

import gunam.solaris.contracts.errors.RepositoryError;
import gunam.solaris.entities.Labratory;
import gunam.solaris.entities.Labratory;
import gunam.solaris.entities.Labratory;
import gunam.solaris.repositories.LabratoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class LabratoryServiceImpl implements LabratoryService {

    private final LabratoryRepository labratoryRepository;
    @Override
    public ResponseEntity<?> addLabratory(Labratory labratory) {
        labratoryRepository.save(labratory);
        return ResponseEntity.status(HttpStatus.OK).body("Labratory Saved DB Successfully");
    }

    @Override
    public ResponseEntity<?> findAllLabratories() {
        List<Labratory> labratories = labratoryRepository.findAll();
        if(labratories==null||labratories.isEmpty()){
            RepositoryError error = new RepositoryError(404,"Any Labratory found !");
            return ResponseEntity.status(HttpStatus.OK).body(error);
        }
        return ResponseEntity.status(HttpStatus.OK).body(labratories);
    }

    @Override
    public ResponseEntity<?> findLabratoryById(int id) {

        Optional<Labratory> foundLabratory = labratoryRepository.findById(id);
        if(!foundLabratory.isPresent()){
            RepositoryError error = new RepositoryError(404,"No Labratory found !");
            return ResponseEntity.status(HttpStatus.OK).body(error);
        }

        Labratory labratory = foundLabratory.get();

        return ResponseEntity.status(HttpStatus.OK).body(labratory);
    }

    @Override
    public ResponseEntity<?> deleteLabratory(int id) {
        if (labratoryRepository.existsById(id)) {
            labratoryRepository.deleteById(id);
            return new ResponseEntity<>("Labratory Deleted Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Labratory Can Not Found By Given Id", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
