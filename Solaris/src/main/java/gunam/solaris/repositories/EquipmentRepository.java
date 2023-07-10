package gunam.solaris.repositories;

import gunam.solaris.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment,Integer> {
}
