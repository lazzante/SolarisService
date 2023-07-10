package gunam.solaris.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "logs")

public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="date")
    private String date;

    @Column(name="time")
    private String time;

    @Column(name="operation")
    private String operation;

    @Column(name="projectUser")
    private String projectUser;

    @Column(name="purposeofoperation")
    private String purposeOfOperation;

    @Column(name="projectcode")
    private String projectCode;

    @Column(name="usageduration")
    private String usageDuration;

    @Column(name="usagemode")
    private String usageMode;

    @Column(name = "instutionname")
    private String instutionName;

    @Column(name = "instutiontype")
    private String instutionType;

    @Column(name = "personname")
    private String personName;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(name = "logs_divisions",joinColumns = @JoinColumn(name = "log_id"),inverseJoinColumns = @JoinColumn(name = "division_id"))
    private Set<Division> divisions;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(name = "logs_equipments",joinColumns = @JoinColumn(name = "log_id"),inverseJoinColumns = @JoinColumn(name = "equipment_id"))
    private Set<Equipment> equipments;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(name = "logs_titles",joinColumns = @JoinColumn(name = "log_id"),inverseJoinColumns = @JoinColumn(name = "title_id"))
    private Set<Title> personTitles;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(name = "logs_positions",joinColumns = @JoinColumn(name = "log_id"),inverseJoinColumns = @JoinColumn(name = "position_id"))
    private Set<Position> personPositions;



















}
