package gunam.solaris.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "equipments")
@Getter
@Setter
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "isforexternalusage")
    private boolean isForExternalUsage;

    @Column(name = "procurementdate")
    private String procurementDate;

    @Column(name = "procurementsource")
    private String procurementSource;

    @Column(name = "fundingsource")
    private String fundingSource;

    @Column(name = "fundingamount")
    private String fundingAmount;

    @Column(name = "manyfacturer")
    private String manyfacturer;

    @Column(name = "equipmentIdentifier")
    private String equipmentIdentifier;

    @Column(name = "equipmentaltname")
    private String equipmentAltName;

    @Column(name = "equipmentengname")
    private String equipmentEngName;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(name = "equipments_labratories",joinColumns = @JoinColumn(name = "equipment_id"),inverseJoinColumns = @JoinColumn(name = "labratory_id"))
    private Set<Labratory> labratories;


    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(name = "equipments_divisions",joinColumns = @JoinColumn(name = "equipment_id"),inverseJoinColumns = @JoinColumn(name = "division_id"))
    private Set<Division> equipmentDivisions;


    @JsonIgnore
    @ManyToMany(mappedBy = "equipments")
    private Set<Log> logs;



}
