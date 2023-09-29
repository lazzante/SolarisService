package gunam.solaris.services;

import gunam.solaris.entities.Position;
import gunam.solaris.entities.Project;
import gunam.solaris.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    @Override
    public ResponseEntity<?> addProject(Project project) {
        projectRepository.save(project);
        return ResponseEntity.status(HttpStatus.OK).body("Project saved in db successfully");
    }

    @Override
    public ResponseEntity<?> getAllProjects() {

        List<Project> projects = projectRepository.findAll();
        if(projects==null||projects.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Any projects found !");
        }
        return ResponseEntity.status(HttpStatus.OK).body(projects);
    }

    @Override
    public ResponseEntity<?> findProjectById(int id) {
        Optional<Project> foundProject = projectRepository.findById(id);
        if(!foundProject.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body("No Project found !");
        }
        Project project = foundProject.get();
        return ResponseEntity.status(HttpStatus.OK).body(project);
    }

    @Override
    public ResponseEntity<?> updateProject(int id, Project project) {
        Optional<Project> foundProject = projectRepository.findById(id);
        if (foundProject.isPresent()) {
            Project _project = foundProject.get();
            _project.setProjectCode(project.getProjectCode());
            _project.setProjectName(project.getProjectName());
            _project.setProjectType(project.getProjectType());
            _project.setStartDate(project.getStartDate());
            _project.setEndDate(project.getEndDate());
            _project.setProjectCoordinator(project.getProjectCoordinator());
            projectRepository.save(_project);
            return new ResponseEntity<>("Project Updated Successfully", HttpStatus.OK);
        }

        else {
            return new ResponseEntity<>("Position Can Not Found By Given Id", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> deleteProject(int id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
            return new ResponseEntity<>("Project Deleted Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Project Can Not Found By Given Id", HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }
}
