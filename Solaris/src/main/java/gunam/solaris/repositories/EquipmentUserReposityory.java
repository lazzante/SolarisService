package gunam.solaris.repositories;

import gunam.solaris.entities.EquipmentUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EquipmentUserReposityory extends JpaRepository<EquipmentUser,Integer> {

    @Query("SELECT e FROM EquipmentUser e WHERE e.equipment.id = :equipmentId")
    List<EquipmentUser> findByEquipmentId(@Param("equipmentId") int equipmentId);
}
