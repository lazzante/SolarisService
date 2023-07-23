package gunam.solaris.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "labratories")
@Getter
@Setter
public class Labratory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "bina")
    private String bina;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(name = "labratories_divisions",joinColumns = @JoinColumn(name = "labratory_id"),inverseJoinColumns = @JoinColumn(name = "division_id"))
    private Set<Division> labratoryDivisions;

    @JsonIgnore
    @ManyToMany(mappedBy = "labratories")
    private Set<Equipment> equipments;


}
