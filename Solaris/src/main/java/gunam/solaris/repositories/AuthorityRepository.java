package gunam.solaris.repositories;

import gunam.solaris.entities.Authority;
import gunam.solaris.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorityRepository extends JpaRepository<Authority,Integer> {



}
