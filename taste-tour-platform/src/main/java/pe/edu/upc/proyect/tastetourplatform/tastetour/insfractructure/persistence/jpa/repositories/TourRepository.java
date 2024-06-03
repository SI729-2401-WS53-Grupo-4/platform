package pe.edu.upc.proyect.tastetourplatform.tastetour.insfractructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.entities.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {

}
