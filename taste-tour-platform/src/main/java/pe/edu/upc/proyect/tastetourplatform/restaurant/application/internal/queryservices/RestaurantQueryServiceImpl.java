package pe.edu.upc.proyect.tastetourplatform.restaurant.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.entities.Restaurant;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.queries.GetRestaurantByIdQuery;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.queries.GetRestaurantByNameQuery;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.services.RestaurantQueryService;
import pe.edu.upc.proyect.tastetourplatform.restaurant.infrastructure.persistence.jpa.repositories.RestaurantRepository;

import java.util.Optional;

@Service
public class RestaurantQueryServiceImpl implements RestaurantQueryService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantQueryServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Optional<Restaurant> handle(GetRestaurantByIdQuery query) {
        return restaurantRepository.findById(query.restaurantId());
    }

    @Override
    public Optional<Restaurant> handle(GetRestaurantByNameQuery query) {
        return restaurantRepository.findByName(query.name());
    }
}
