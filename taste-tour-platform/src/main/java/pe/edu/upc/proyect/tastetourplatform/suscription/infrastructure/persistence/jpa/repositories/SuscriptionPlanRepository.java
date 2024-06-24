package pe.edu.upc.proyect.tastetourplatform.suscription.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.proyect.tastetourplatform.suscription.domain.model.entities.SuscriptionPlan;

@Repository
public interface SuscriptionPlanRepository extends JpaRepository<SuscriptionPlan, Long> {

}
