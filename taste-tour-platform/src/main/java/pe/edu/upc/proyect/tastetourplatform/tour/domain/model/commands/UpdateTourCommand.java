package pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands;

import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.valueobjects.*;

import java.util.List;

public record UpdateTourCommand(Long tourId,
                                String titleTour,
                                ImageTour imageTour,
                                String instructor,
                                Long rating,
                                Long nRatings,
                                Price minPrice,
                                Long currentPeople,
                                Long maxPeople,
                                String language,
                                Long duration,
                                List<String> itemsIncluded,
                                String date,
                                String description,
                                List<String> times,
                                String hours,
                                Long restaurantId) {
}
