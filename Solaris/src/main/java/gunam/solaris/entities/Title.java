package gunam.solaris.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "titles")
@Getter
@Setter
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title_short")
    private String title_short;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "titles")//DİĞER CLASSDAKİ SET'İN İSMİ
    private Set<User> users;

    @JsonIgnore
    @ManyToMany(mappedBy = "personTitles")//DİĞER CLASSDAKİ SET'İN İSMİ
    private Set<Log> logs;

}