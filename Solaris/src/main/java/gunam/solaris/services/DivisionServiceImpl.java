package gunam.solaris.services;

import gunam.solaris.contracts.errors.RepositoryError;
import gunam.solaris.entities.Division;
import gunam.solaris.repositories.DivisionRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@AllArgsConstructor
@Service
public class DivisionServiceImpl implements DivisionService {

    private final DivisionRepository divisionRepository;
    @Override
    public ResponseEntity<?> addDivision(Division division) {
        divisionRepository.save(division);
        return ResponseEntity.status(HttpStatus.OK).body("Division saved in db successfully");
    }

    @Override
    public ResponseEntity<?> findAllDivisions() {
        List<Division> divisions = divisionRepository.findAll();
        if(divisions==null||divisions.isEmpty()){
            RepositoryError error = new RepositoryError(200,"Any divisions found !");
           return ResponseEntity.status(HttpStatus.OK).body(error);
        }
        return ResponseEntity.status(HttpStatus.OK).body(divisions);
    }

    @Override
    public ResponseEntity<?> findDivisionById(int id) {
        Optional<Division> foundDivision = divisionRepository.findById(id);
        if(!foundDivision.isPresent()){
            RepositoryError error = new RepositoryError(200,"No division found !");
            return ResponseEntity.status(HttpStatus.OK).body(error);
        }

        Division division = foundDivision.get();

        return ResponseEntity.status(HttpStatus.OK).body(division);
    }

    @Override
    public ResponseEntity<?> deleteDivision(int id) {
        if (divisionRepository.existsById(id)) {
            divisionRepository.deleteById(id);
            return new ResponseEntity<>("Division Deleted Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Division Can Not Found By Given Id", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
