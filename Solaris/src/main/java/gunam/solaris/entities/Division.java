package gunam.solaris.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "divisions")
@Getter
@Setter
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "short_name")
    private String short_name;

    @JsonIgnore
    @ManyToMany(mappedBy = "divisions")
    private Set<User> users;


    @JsonIgnore
    @ManyToMany(mappedBy = "divisions")
    private Set<Log> logs;


    @JsonIgnore
    @ManyToMany(mappedBy = "equipmentDivisions")
    private Set<Equipment> equipments;

    @JsonIgnore
    @ManyToMany(mappedBy = "labratoryDivisions")
    private Set<Labratory> labratories;


}