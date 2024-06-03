package pe.edu.upc.proyect.tastetourplatform.tastetour.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.entities.Tour;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.commands.AddTourCommand;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.commands.DeleteTourCommand;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.services.TourCommandService;
import pe.edu.upc.proyect.tastetourplatform.tastetour.insfractructure.persistence.jpa.repositories.TourRepository;

@Service
public class TourCommandServiceImpl implements TourCommandService {
    private final TourRepository tourRepository;

    public TourCommandServiceImpl(TourRepository tourRepository){
        this.tourRepository = tourRepository;
    }

    @Override
    public Long handle(AddTourCommand command){
        Tour tour = new Tour(
                command.titleTour(),
                command.instructor(),
                command.description(),
                command.rating(),
                command.capacity(),
                command.duration(),
                command.date(),
                command.price()
        );
        tourRepository.save(tour);
        return tour.getId();
    }
    @Override
    public void handle(DeleteTourCommand command){
        tourRepository.deleteById(command.tourId());
        System.out.println("Tour Delete");
    }
}
