package aventure.solo.moteur.oracle.persistence.repository;

import aventure.solo.moteur.oracle.persistence.entity.AventureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataAventureRepository extends JpaRepository<AventureEntity, UUID> {
}
