package gunam.solaris.services;

import gunam.solaris.entities.Log;
import org.springframework.http.ResponseEntity;

public interface LogService {

    ResponseEntity<?> addLog(Log log);

    ResponseEntity<?> findAllLogs();

    ResponseEntity<?> findLogById(int id);
    ResponseEntity<?> deleteLog(int id);
}
