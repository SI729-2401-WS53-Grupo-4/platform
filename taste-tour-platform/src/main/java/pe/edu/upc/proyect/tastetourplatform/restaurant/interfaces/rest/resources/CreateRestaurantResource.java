package pe.edu.upc.proyect.tastetourplatform.restaurant.interfaces.rest.resources;

import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.valueobjects.Image;

public record CreateRestaurantResource(String name, String description, String image, String bookingLink) {
}
