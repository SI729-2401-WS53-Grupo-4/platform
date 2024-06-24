package pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.transform;

import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.valueobjects.Image;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.AddTourCommand;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.valueobjects.ImageTour;
import pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.resources.CreateTourResource;

public class CreateTourCommandFromResourceAssembler {

    public static AddTourCommand toCommandFromResource(CreateTourResource resource){
        ImageTour image = new ImageTour(resource.image());
         return new AddTourCommand(resource.titleTour(),
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
