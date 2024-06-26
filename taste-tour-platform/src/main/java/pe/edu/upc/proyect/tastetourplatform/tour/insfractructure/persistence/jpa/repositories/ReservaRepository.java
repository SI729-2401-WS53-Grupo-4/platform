package pe.edu.upc.proyect.tastetourplatform.tour.insfractructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.aggregates.Reserva;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.entities.Tour;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
