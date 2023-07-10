package gunam.solaris.services;

import gunam.solaris.contracts.errors.RepositoryError;
import gunam.solaris.entities.Log;
import gunam.solaris.entities.Title;
import gunam.solaris.repositories.LogRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;

    @Override
    public ResponseEntity<?> addLog(Log log) {
        logRepository.save(log);
        return ResponseEntity.status(HttpStatus.OK).body("Log Saved DB Successfully");
    }

    @Override
    public ResponseEntity<?> findAllLogs() {
        List<Log> logs = logRepository.findAll();
        if(logs==null||logs.isEmpty()){
            RepositoryError error = new RepositoryError(404,"Any logs found !");
            return ResponseEntity.status(HttpStatus.OK).body(error);
        }
        return ResponseEntity.status(HttpStatus.OK).body(logs);
    }

    @Override
    public ResponseEntity<?> findLogById(int id) {
        Optional<Log> foundLog = logRepository.findById(id);
        if(!foundLog.isPresent()){
            RepositoryError error = new RepositoryError(404,"No Log found !");
            return ResponseEntity.status(HttpStatus.OK).body(error);
        }

        Log log = foundLog.get();

        return ResponseEntity.status(HttpStatus.OK).body(log);

    }

    @Override
    public ResponseEntity<?> deleteLog(int id) {
        if (logRepository.existsById(id)) {
            logRepository.deleteById(id);
            return new ResponseEntity<>("Log Deleted Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Log Can Not Found By Given Id", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }


}
