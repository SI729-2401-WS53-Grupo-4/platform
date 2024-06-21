package pe.edu.upc.proyect.tastetourplatform.user.insfractructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.valueobjects.UserId;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsById(Long id);
}
