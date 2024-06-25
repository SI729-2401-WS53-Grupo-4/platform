package pe.edu.upc.proyect.tastetourplatform.tour.domain.services;

import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.aggregates.Reserva;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.AddBookingDetailsCommand;

public interface ReservaCommandService {
    Reserva handle (AddBookingDetailsCommand command);
}
