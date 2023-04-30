package gunam.solaris.services;

import gunam.solaris.entities.Position;
import gunam.solaris.repositories.PositionRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;
    @Override
    public ResponseEntity<?> addPosition(Position position) {
        positionRepository.save(position);
        return ResponseEntity.status(HttpStatus.OK).body("Position saved in db successfully");
    }

    @Override
    public ResponseEntity<?> getAllPositions() {
        List<Position> positions = positionRepository.findAll();
        if(positions==null||positions.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Any positions found !");
        }
        return ResponseEntity.status(HttpStatus.OK).body(positions);
    }

    @Override
    public ResponseEntity<?> findPositionById(int id) {
        Optional<Position> foundPosition = positionRepository.findById(id);
        if(!foundPosition.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body("No Position found !");
        }
        Position position = foundPosition.get();
        return ResponseEntity.status(HttpStatus.OK).body(position);
    }

    @Override
    public ResponseEntity<?> updatePosition(int id, Position position) {
        Optional<Position> foundPosition = positionRepository.findById(id);
        if (foundPosition.isPresent()) {
            Position _position = foundPosition.get();
            _position.setDescription(position.getDescription());
            _position.setName(position.getName());
            positionRepository.save(_position);
            return new ResponseEntity<>("Position Updated Successfully", HttpStatus.OK);
        }

        else {
            return new ResponseEntity<>("Position Can Not Found By Given Id", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> deletePosition(int id) {
        if (positionRepository.existsById(id)) {
            positionRepository.deleteById(id);
            return new ResponseEntity<>("Position Deleted Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Position Can Not Found By Given Id", HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }
}
