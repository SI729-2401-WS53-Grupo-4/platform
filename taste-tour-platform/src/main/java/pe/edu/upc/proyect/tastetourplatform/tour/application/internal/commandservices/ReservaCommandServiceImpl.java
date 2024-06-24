package pe.edu.upc.proyect.tastetourplatform.tour.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.aggregates.Reserva;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.AddBookingCommand;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.AddTourToBookingCommand;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.DeleteBookingCommand;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.entities.Tour;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.services.ReservaCommandService;
import pe.edu.upc.proyect.tastetourplatform.tour.insfractructure.persistence.jpa.repositories.ReservaRepository;
import pe.edu.upc.proyect.tastetourplatform.tour.insfractructure.persistence.jpa.repositories.TourRepository;

@Service
public class ReservaCommandServiceImpl implements ReservaCommandService {
    private final ReservaRepository reservaRepository;

    private final TourRepository tourRepository;

    public ReservaCommandServiceImpl(ReservaRepository reservaRepository, TourRepository tourRepository) {
        this.reservaRepository = reservaRepository;
        this.tourRepository = tourRepository;
    }


    @Override
    public Long handle(AddTourToBookingCommand command) {
        Reserva reserva = reservaRepository.findById(command.reservaId())
                .orElseThrow(() -> new RuntimeException("Reserva not found"));

        Tour tourId = tourRepository.findById(command.tourId())
                .orElseThrow(() ->new RuntimeException("Tour not found"));

        reserva.setTour_id(tourId);
        reservaRepository.save(reserva);
        return reserva.getId();
    }

    @Override
    public void handle(DeleteBookingCommand command) {
        reservaRepository.deleteById(command.reservaId());
    }
}
