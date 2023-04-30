package gunam.solaris.services;

import gunam.solaris.entities.Division;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DivisionService {
    ResponseEntity<?> addDivision(Division division);

    ResponseEntity<?> findAllDivisions();

    ResponseEntity<?> findDivisionById(int id);
}
