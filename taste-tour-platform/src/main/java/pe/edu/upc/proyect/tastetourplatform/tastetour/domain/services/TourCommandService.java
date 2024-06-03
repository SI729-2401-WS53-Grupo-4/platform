package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.services;

import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.commands.AddTourCommand;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.commands.DeleteTourCommand;

public interface TourCommandService {
    Long handle(AddTourCommand command);
    void handle(DeleteTourCommand command);
}
