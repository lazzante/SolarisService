package gunam.solaris.services;

import gunam.solaris.contracts.errors.RepositoryError;
import gunam.solaris.entities.Title;
import gunam.solaris.repositories.TitleRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TitleServiceImpl implements TitleService {

    private final TitleRepository titleRepository;
    @Override
    public ResponseEntity<?> addTitle(Title title) {
        titleRepository.save(title);
        return ResponseEntity.status(HttpStatus.OK).body("Title saved in db successfully");
    }

    @Override
    public ResponseEntity<?> findAllTitles() {
        List<Title> titles = titleRepository.findAll();
        if(titles==null||titles.isEmpty()){
            RepositoryError error = new RepositoryError(200,"Any titles found !");
            return ResponseEntity.status(HttpStatus.OK).body(error);
        }
        return ResponseEntity.status(HttpStatus.OK).body(titles);
    }

    @Override
    public ResponseEntity<?> findTitleById(int id) {
        Optional<Title> foundTitle = titleRepository.findById(id);
        if(!foundTitle.isPresent()){
            RepositoryError error = new RepositoryError(200,"No Title found !");
            return ResponseEntity.status(HttpStatus.OK).body(error);
        }

        Title title = foundTitle.get();

        return ResponseEntity.status(HttpStatus.OK).body(title);
    }
}
