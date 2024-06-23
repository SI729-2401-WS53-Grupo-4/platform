package pe.edu.upc.proyect.tastetourplatform.restaurant.interfaces.rest.transform;

import org.apache.commons.text.StringEscapeUtils;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.entities.Restaurant;
import pe.edu.upc.proyect.tastetourplatform.restaurant.interfaces.rest.resources.RestaurantResource;

public class RestaurantResourceFromEntityAssembler {
    public static RestaurantResource toResourceFromEntity(Restaurant entity){
        String imageUrl = entity.getImage().imageUrl();
        String sanitizedImageUrl = StringEscapeUtils.escapeHtml4(imageUrl);
        return new RestaurantResource(entity.getId(), entity.getName(), entity.getDescription(), sanitizedImageUrl, entity.getBookingLink());
    }
}
