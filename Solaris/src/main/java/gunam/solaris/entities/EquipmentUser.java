package gunam.solaris.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "eq_users")
@Getter
@Setter
public class EquipmentUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "usertype")
    private String userType;

    @Column(name = "status")
    private String status;

    @Column(name = "authdate")
    private String authdate;

    @Column(name = "division")
    private String division;


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;





}
