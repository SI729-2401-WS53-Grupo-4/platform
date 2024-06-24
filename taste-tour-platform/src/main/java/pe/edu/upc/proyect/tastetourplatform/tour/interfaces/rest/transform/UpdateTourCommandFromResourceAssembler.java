package pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.transform;

import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.UpdateTourCommand;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.valueobjects.ImageTour;
import pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.resources.UpdateTourResource;

public class UpdateTourCommandFromResourceAssembler {
    public static UpdateTourCommand toCommandFromResource(Long id, UpdateTourResource resource){
        ImageTour image = new ImageTour(resource.imageTour());
        return new UpdateTourCommand(id,
                resource.titleTour(),
                image,
                resource.instructor(),
                resource.rating(),
                resource.nRatings(),
                resource.minPrice(),
                resource.currentPeople(),
                resource.maxPeople(),
                resource.language(),
                resource.duration(),
                resource.itemsIncluded(),
                resource.date(),
                resource.description(),
                resource.times(),
                resource.hours(),
                resource.restaurantId());
    }
}
