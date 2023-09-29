package gunam.solaris.controllers;

import gunam.solaris.entities.Position;
import gunam.solaris.entities.Project;
import gunam.solaris.services.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
@AllArgsConstructor
public class ProjectController {


    private final ProjectService projectService;


    @CrossOrigin
    @PostMapping("/add")
    ResponseEntity<?> addProject(@RequestBody Project project) {
        return projectService.addProject(project);
    }

    @CrossOrigin
    @GetMapping("/getAll")
    ResponseEntity<?> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/find/{id}")
    ResponseEntity<?> findProjectById(@PathVariable("id") int id) {
        return projectService.findProjectById(id);
    }


    @PutMapping("/update/{id}")
    ResponseEntity<?> updateProject(@PathVariable("id") int id,@RequestBody Project project) {
        return projectService.updateProject(id,project);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteProject(@PathVariable("id") int id) {
        return projectService.deleteProject(id);
    }


}
