package pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.transform;

import pe.edu.upc.proyect.tastetourplatform.user.domain.model.aggregates.Review;
import pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.resources.ReviewResource;

public class ReviewResourceFromEntityAssembler {
    public static ReviewResource toResourceFromEntity(Review entity){
        return new ReviewResource(entity.getId(), entity.getRating(), entity.getComment());
    }
}
