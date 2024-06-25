package pe.edu.upc.proyect.tastetourplatform.tour.application.internal.commandservices;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.aggregates.Reserva;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.AddBookingDetailsCommand;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.entities.Tour;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.services.ReservaCommandService;
import pe.edu.upc.proyect.tastetourplatform.tour.insfractructure.persistence.jpa.repositories.ReservaRepository;
import pe.edu.upc.proyect.tastetourplatform.tour.insfractructure.persistence.jpa.repositories.TourRepository;

@Service
public class ReservaCommandServiceImpl implements ReservaCommandService {

    private final TourRepository tourRepository;

    private final ReservaRepository reservaRepository;

    public ReservaCommandServiceImpl(TourRepository tourRepository, ReservaRepository reservaRepository) {
        this.tourRepository = tourRepository;
        this.reservaRepository = reservaRepository;
    }

    @Override
    @Transactional
    public Reserva handle(AddBookingDetailsCommand command) {
        Tour tour = tourRepository.findById(command.tourId())
                .orElseThrow(() -> new IllegalArgumentException("Tour not found"));

        Reserva reserva = new Reserva(tour);
        reserva.setTitleTour(tour.getTitleTour());
        reserva.setImageTour(tour.getImageTour());
        reserva.setDuration(tour.getDuration());
        reserva.setMinPrice(tour.getMinPrice());

        Reserva savedReserva = reservaRepository.save(reserva);

        return savedReserva;
    }
}
