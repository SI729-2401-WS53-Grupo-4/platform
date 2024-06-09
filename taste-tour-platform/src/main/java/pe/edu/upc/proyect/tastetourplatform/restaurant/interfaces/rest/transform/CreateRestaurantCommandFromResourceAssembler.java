package pe.edu.upc.proyect.tastetourplatform.restaurant.interfaces.rest.transform;

import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.commands.CreateRestaurantCommand;
import pe.edu.upc.proyect.tastetourplatform.restaurant.interfaces.rest.resources.CreateRestaurantResource;

public class CreateRestaurantCommandFromResourceAssembler {

    public static CreateRestaurantCommand toCommandFromResource(CreateRestaurantResource resource){
        return new CreateRestaurantCommand(resource.name(), resource.location(), resource.time(), resource.description());
    }
}
