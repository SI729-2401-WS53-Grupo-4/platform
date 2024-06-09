package pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands;

import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.entities.Restaurant;

public record AddRestaurantToTourCommand (Long tourId, Restaurant restaurantId) {
}
