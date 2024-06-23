package pe.edu.upc.proyect.tastetourplatform.user.insfractructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.aggregates.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    boolean existsById(Long id);
}
