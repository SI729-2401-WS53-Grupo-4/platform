package pe.edu.upc.proyect.tastetourplatform.tour.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.AddRestaurantToTourCommand;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.UpdateTourCommand;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.entities.Tour;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.AddTourCommand;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.DeleteTourCommand;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.services.TourCommandService;
import pe.edu.upc.proyect.tastetourplatform.tour.insfractructure.persistence.jpa.repositories.TourRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

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
                command.price(),
                command.restauranteId()
        );
        tourRepository.save(tour);
        return tour.getId();
    }

    @Override
    public Optional<Tour> handle(UpdateTourCommand command) {
        var result = tourRepository.findById(command.tourId());
        if (result.isEmpty())
            throw new IllegalArgumentException("Tour does not exist");
        var tourToUpdated = result.get();
        try{
            var updatedTour = tourRepository.save(tourToUpdated.updatedInformation(command.titleTour(),command.instructor(), command.description(),command.rating(),command.capacity(),command.duration(),command.date(),command.price(), command.restauranteId()));
            return Optional.of(updatedTour);
        } catch (Exception e){
            throw new IllegalArgumentException("Error while updating tour: " + e.getMessage());
        }
    }

    @Override
    public Long handle(AddRestaurantToTourCommand command) {
        Tour tour = tourRepository.findById(command.tourId())
                .orElseThrow(() -> new RuntimeException("Tour not found"));

        tour.setRestauranteId(command.restauranteId());
        tourRepository.save(tour);
        return tour.getId();
    }

    @Override
    public void handle(DeleteTourCommand command){
        tourRepository.deleteById(command.tourId());
        System.out.println("Tour Delete");
    }
}
