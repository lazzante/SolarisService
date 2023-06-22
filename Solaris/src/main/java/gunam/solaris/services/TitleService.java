package gunam.solaris.services;

import gunam.solaris.entities.Title;
import org.springframework.http.ResponseEntity;

public interface TitleService {
    ResponseEntity<?> addTitle(Title title);

    ResponseEntity<?> findAllTitles();

    ResponseEntity<?> findTitleById(int id);

    ResponseEntity<?> deleteTitle(int id);
}
