package pe.edu.upc.proyect.tastetourplatform.user.insfractructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.aggregates.DebitCard;

@Repository
public interface CardRepository extends JpaRepository<DebitCard, Long> {
    boolean existsById(Long id);
}
