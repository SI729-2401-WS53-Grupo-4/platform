package pe.edu.upc.proyect.tastetourplatform.restaurant.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.commands.CreateRestaurantCommand;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.commands.DeleteRestaurantCommand;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.entities.Restaurant;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.services.RestaurantCommandService;
import pe.edu.upc.proyect.tastetourplatform.restaurant.infrastructure.persistence.jpa.repositories.RestaurantRepository;

@Service
public class RestaurantCommandServiceImpl implements RestaurantCommandService {
private final RestaurantRepository restaurantRepository;

public RestaurantCommandServiceImpl(RestaurantRepository restaurantRepository){
this.restaurantRepository = restaurantRepository;
}

    @Override
    public Long handle(CreateRestaurantCommand command) {
        if(restaurantRepository.existsByName(command.name())) {
            throw new IllegalArgumentException("Restaurant with the same name already exists");
        }

        var restaurant = new Restaurant(command);

        try {
            restaurantRepository.save(restaurant);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving restaurant: " + e.getMessage());
        }
        return restaurant.getId();
    }

    @Override
    public void handle(DeleteRestaurantCommand command) {
        restaurantRepository.deleteById(command.restaurantId());
        System.out.println("Restaurant Delete");
    }
}

