package pe.edu.upc.proyect.tastetourplatform.tour.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.aggregates.Reserva;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.queries.GetAllReservationsQuery;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.queries.GetReservationsByIdQuery;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.services.ReservaQueryService;
import pe.edu.upc.proyect.tastetourplatform.tour.insfractructure.persistence.jpa.repositories.ReservaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaQueryServiceImpl implements ReservaQueryService {

    private final ReservaRepository reservaRepository;

    public ReservaQueryServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public List<Reserva> handle(GetAllReservationsQuery query) {
        return reservaRepository.findAll();
    }

    @Override
    public Optional<Reserva> handle(GetReservationsByIdQuery query) {
        return reservaRepository.findById(query.reservaId());
    }
}
