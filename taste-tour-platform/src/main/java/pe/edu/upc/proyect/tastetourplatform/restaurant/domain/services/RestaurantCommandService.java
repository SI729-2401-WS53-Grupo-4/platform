package pe.edu.upc.proyect.tastetourplatform.restaurant.domain.services;

import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.commands.CreateRestaurantCommand;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.commands.DeleteRestaurantCommand;

public interface RestaurantCommandService {
    Long handle(CreateRestaurantCommand command);

    void handle(DeleteRestaurantCommand command);
}
