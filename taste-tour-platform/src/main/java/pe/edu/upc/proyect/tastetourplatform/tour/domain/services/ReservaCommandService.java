package pe.edu.upc.proyect.tastetourplatform.tour.domain.services;

import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.AddBookingCommand;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.AddTourToBookingCommand;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.DeleteBookingCommand;

public interface ReservaCommandService {
    Long handle (AddTourToBookingCommand command);
    void handle (DeleteBookingCommand command);
}
