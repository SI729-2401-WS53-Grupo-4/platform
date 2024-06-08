package pe.edu.upc.proyect.tastetourplatform.tour.domain.services;

import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.AddTourCommand;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.DeleteTourCommand;

public interface TourCommandService {
    Long handle(AddTourCommand command);
    void handle(DeleteTourCommand command);
}
