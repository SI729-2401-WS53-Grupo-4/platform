package pe.edu.upc.proyect.tastetourplatform.tour.domain.services;

import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.AddTourCommand;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.DeleteTourCommand;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.UpdateTourCommand;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.entities.Tour;

import java.util.Optional;

public interface TourCommandService {
    Long handle(AddTourCommand command);
    Optional<Tour> handle (UpdateTourCommand command);
    void handle(DeleteTourCommand command);
}
