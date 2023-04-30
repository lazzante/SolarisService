package gunam.solaris.services;

import gunam.solaris.entities.Position;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PositionService {
    ResponseEntity<?> addPosition(Position position);

    ResponseEntity<?> getAllPositions();

    ResponseEntity<?> findPositionById(int id);

    ResponseEntity<?> updatePosition(int id, Position position);

    ResponseEntity<?> deletePosition(int id);
}
