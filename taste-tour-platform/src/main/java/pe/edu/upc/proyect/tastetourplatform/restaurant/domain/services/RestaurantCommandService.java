package pe.edu.upc.proyect.tastetourplatform.restaurant.domain.services;

import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.commands.CreateRestaurantCommand;

public interface RestaurantCommandService {
    Long handle(CreateRestaurantCommand command);
}
