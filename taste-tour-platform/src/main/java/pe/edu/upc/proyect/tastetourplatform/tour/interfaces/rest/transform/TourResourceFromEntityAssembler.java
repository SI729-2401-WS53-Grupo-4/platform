package pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.transform;

import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.entities.Tour;
import pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.resources.TourResource;

public class TourResourceFromEntityAssembler {

    public static TourResource toResourceFromEntity(Tour entity){
        return new TourResource(entity.getId(), entity.getTitleTour(), entity.getDescription(), entity.getInstructor(),entity.getRating(),entity.getCapacity(),entity.getDuration(),entity.getDate(),entity.getPrice(),entity.getRestauranteId());
    }
}
