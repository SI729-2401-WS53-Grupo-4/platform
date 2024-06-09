package pe.edu.upc.proyect.tastetourplatform.restaurant.interfaces.rest.transform;

import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.entities.Restaurant;
import pe.edu.upc.proyect.tastetourplatform.restaurant.interfaces.rest.resources.RestaurantResource;

public class RestaurantResourceFromEntityAssembler {
    public static RestaurantResource toResourceFromEntity(Restaurant entity){
        return new RestaurantResource(entity.getId(), entity.getName(), entity.getLocation(), entity.getTime(), entity.getDescription());
    }
}
