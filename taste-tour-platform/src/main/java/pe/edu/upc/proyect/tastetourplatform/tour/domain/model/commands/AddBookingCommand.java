package pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands;

import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.valueobjects.Price;

public record AddBookingCommand(String title, String image, Integer duration, Price price) {
}
