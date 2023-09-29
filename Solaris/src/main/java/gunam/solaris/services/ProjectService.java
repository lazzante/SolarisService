package gunam.solaris.services;

import gunam.solaris.entities.Position;
import gunam.solaris.entities.Project;
import org.springframework.http.ResponseEntity;

public interface ProjectService {
    ResponseEntity<?> addProject(Project project);

    ResponseEntity<?> getAllProjects();

    ResponseEntity<?> findProjectById(int id);

    ResponseEntity<?> updateProject(int id, Project project);

    ResponseEntity<?> deleteProject(int id);
}
