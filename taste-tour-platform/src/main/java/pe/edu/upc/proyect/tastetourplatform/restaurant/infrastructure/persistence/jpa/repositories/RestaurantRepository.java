package pe.edu.upc.proyect.tastetourplatform.restaurant.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.entities.Restaurant;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findByName(String name);

    boolean existsByName(String name);
}
