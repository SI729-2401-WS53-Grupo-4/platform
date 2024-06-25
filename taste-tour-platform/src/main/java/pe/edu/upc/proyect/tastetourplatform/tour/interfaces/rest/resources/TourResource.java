package pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.resources;

import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.valueobjects.*;

import java.util.List;

public record TourResource(Long id, String titleTour,
                           String imageTour,
                           String instructor,
                           Long rating,
                           Long nRatings,
                           Long minPrice,
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
