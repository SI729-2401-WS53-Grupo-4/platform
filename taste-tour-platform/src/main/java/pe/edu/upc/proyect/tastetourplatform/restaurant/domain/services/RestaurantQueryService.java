package pe.edu.upc.proyect.tastetourplatform.restaurant.domain.services;

import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.entities.Restaurant;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.queries.GetAllRestaurantsQuery;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.queries.GetRestaurantByIdQuery;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.queries.GetRestaurantByNameQuery;

import java.util.List;
import java.util.Optional;

public interface RestaurantQueryService {

    List<Restaurant> handle(GetAllRestaurantsQuery query);
    Optional<Restaurant> handle(GetRestaurantByIdQuery query);
    Optional<Restaurant> handle(GetRestaurantByNameQuery query);

}
