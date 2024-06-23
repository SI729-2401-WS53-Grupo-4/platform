package pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.transform;

import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.AddTourCommand;
import pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.resources.CreateTourResource;

public class CreateTourCommandFromResourceAssembler {

    public static AddTourCommand toCommandFromResource(CreateTourResource resource){
         return new AddTourCommand(resource.titleTour(),resource.description(),resource.instructor(),resource.rating(),resource.capacity(),resource.duration(),resource.date(),resource.price(), resource.restaurantId());
    }
}
