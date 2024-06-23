package pe.edu.upc.proyect.tastetourplatform.restaurant.interfaces.rest.transform;

import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.commands.CreateRestaurantCommand;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.valueobjects.Image;
import pe.edu.upc.proyect.tastetourplatform.restaurant.interfaces.rest.resources.CreateRestaurantResource;

public class CreateRestaurantCommandFromResourceAssembler {

    public static CreateRestaurantCommand toCommandFromResource(CreateRestaurantResource resource){
        Image image = new Image(resource.image());
        return new CreateRestaurantCommand(resource.name(), resource.description(),image, resource.bookingLink());
    }
}
