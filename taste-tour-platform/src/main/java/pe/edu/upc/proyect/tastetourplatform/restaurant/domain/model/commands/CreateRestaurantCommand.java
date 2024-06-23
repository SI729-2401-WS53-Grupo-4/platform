package pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.commands;

import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.valueobjects.Image;

public record CreateRestaurantCommand(String name, String description, Image image, String bookingLink) {

}
