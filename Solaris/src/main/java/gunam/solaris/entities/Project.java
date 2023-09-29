package gunam.solaris.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "projects")
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "projectCode")
    private String projectCode;

    @Column(name = "projectName")
    private String projectName;

    @Column(name = "startDate")
    private String startDate;

    @Column(name = "endDate")
    private String endDate;

    @Column(name = "projectType")
    private String projectType;

    @Column(name = "projectCoordinator")
    private String projectCoordinator;



}
