package pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands;

public record AddRestaurantToTourCommand (Long tourId, Long restauranteId) {
}
