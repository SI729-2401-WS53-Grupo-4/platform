package pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.transform;

import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.UpdateTourCommand;
import pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.resources.UpdateTourResource;

public class UpdateTourCommandFromResourceAssembler {
    public static UpdateTourCommand toCommandFromResource(Long id, UpdateTourResource resource){
        return new UpdateTourCommand(id,resource.titleTour(),resource.description(),resource.instructor(),resource.rating(),resource.capacity(),resource.duration(),resource.date(),resource.price());
    }
}
