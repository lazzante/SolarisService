package gunam.solaris.services;

import gunam.solaris.entities.Labratory;
import org.springframework.http.ResponseEntity;

public interface LabratoryService {

    ResponseEntity<?> addLabratory(Labratory labratory);

    ResponseEntity<?> findAllLabratories();

    ResponseEntity<?> findLabratoryById(int id);
    ResponseEntity<?> deleteLabratory(int id);
}
