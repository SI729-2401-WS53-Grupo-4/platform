package pe.edu.upc.proyect.tastetourplatform.tour.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.entities.Restaurant;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.services.RestaurantQueryService;
import pe.edu.upc.proyect.tastetourplatform.restaurant.infrastructure.persistence.jpa.repositories.RestaurantRepository;
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
    private final RestaurantRepository restaurantRepository;

    public TourCommandServiceImpl(TourRepository tourRepository, RestaurantRepository restaurantRepository) {
        this.tourRepository = tourRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Long handle(AddTourCommand command){
        Restaurant restaurantId = restaurantRepository.findById(command.restaurantId())
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));

        Tour tour = new Tour(
                command.titleTour(),
                command.instructor(),
                command.description(),
                command.rating(),
                command.capacity(),
                command.duration(),
                command.date(),
                command.price(),
                restaurantId
        );
        tourRepository.save(tour);
        return tour.getId();
    }

    @Override
    public Optional<Tour> handle(UpdateTourCommand command) {
        var result = tourRepository.findById(command.tourId());
        if (result.isEmpty())
            throw new IllegalArgumentException("Tour does not exist");
        var tourToUpdate = result.get();

        Restaurant restaurantId = restaurantRepository.findById(command.restaurantId().getId())
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));

        try {
            var updatedTour = tourRepository.save(tourToUpdate.updatedInformation(
                    command.titleTour(),
                    command.instructor(),
                    command.description(),
                    command.rating(),
                    command.capacity(),
                    command.duration(),
                    command.date(),
                    command.price(),
                    restaurantId));
            return Optional.of(updatedTour);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating tour: " + e.getMessage());
        }
    }

    @Override
    public Long handle(AddRestaurantToTourCommand command) {
        Tour tour = tourRepository.findById(command.tourId())
                .orElseThrow(() -> new RuntimeException("Tour not found"));

        Restaurant restaurantId = restaurantRepository.findById(command.restaurantId().getId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        tour.setRestaurantId(restaurantId);
        tourRepository.save(tour);
        return tour.getId();
    }

    @Override
    public void handle(DeleteTourCommand command){
        tourRepository.deleteById(command.tourId());
        System.out.println("Tour Delete");
    }
}
