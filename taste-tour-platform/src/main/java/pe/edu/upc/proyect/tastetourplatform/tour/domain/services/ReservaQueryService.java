package pe.edu.upc.proyect.tastetourplatform.tour.domain.services;

import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.aggregates.Reserva;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.queries.GetAllReservationsQuery;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.queries.GetReservationsByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ReservaQueryService {
    List<Reserva> handle(GetAllReservationsQuery query);
    Optional<Reserva> handle(GetReservationsByIdQuery query);
}
