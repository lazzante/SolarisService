package gunam.solaris.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_authorities",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name ="authority_id" ))
    private Set<Authority> authorities;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_titles",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "title_id"))
    private Set<Title> titles;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_positions",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "position_id"))
    private Set<Position> positions;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_divisions",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "division_id"))
    private Set<Division> divisions;

}
